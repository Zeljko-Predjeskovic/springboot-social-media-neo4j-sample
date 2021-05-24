/**
 * # Object Mapping
 *
 * To convert models between the database and domain easier, we are using
 * the object mapping technike. It prevents inserting same models with different
 * bulding blocks.
 *
 * ### Example of a Graph model:
 *
 * We are mapping our objects in a graph.
 * The colored circles are the nodes.
 * The nodes are connected with arrows which are the relations.
 * Nodes can also be seen as entities and will be coded as java classes
 * while the relations are associated attributes where the object is the target
 * node.
 *
 * <img src="./images/graphDia.png" alt="graphImage" width="450px"/>
 */


/**
 * ### Id and Generated value
 *
 *
 *
 *
 * In this project we use lombok to save some lines of code.
 * So stuff like *@ToString, @Getter, @Setter,* are just genaretig some methods.
 * Sometimes it is necessary to still write it yourself. For example
 * if i have a class that has a relationship with itself, the generated
 * ToString could get recursive and get you a overflow exception.
 *
 */

/**
 * A persistable class where we give every node and relation class an Id.
 */
public class Persistable {

    /**
     * The Id is needed for the neo4j driver. It will not work without it.
     * You can define an Id with the *@Id* annotation and
     * the *@GeneratedValue* will automatically generate an Id with the type Long in the database.
     * Default generates the next available number.
     */
    @Id @GeneratedValue
    private Long id;

    /**
     * You can change your key generation for example into a UUID:
     */
    @Id @GeneratedValue(UUIDStringGenerator.class)
    private String id;

        --equals,getter,setter--
    }
}


/**
 * ### Node entities and relations
 */

/**
 * Annotion *@Node* defines the class as a node. In this scenario, the class
 * is a node named "Person"
 */
@Node("Person")
public class PersonNode extends Persistable{

    /**
     * The Person node hast two properties: username and email.
     */
    @Property("username")
    @Getter @Setter
    private String username;

    @Property("email")
    @Getter @Setter
    private String email;


    /**
     *  Annotation *@Relationship* creates a relationship. In this case the
     *  relation is "FOLLOWS". In default the relation arrow will point to the
     *  friend Node.
     */
    @Nullable @Getter
    @Relationship(type = "FOLLOWS")
    private List<PersonNode> friends;

    /**
     * You can adjust the arrow pointing like in this annotaion.
     */
    @Relationship(type = "FOLLOWS", direction = Relationship.Direction.INCOMING)

    /**
     * Add method for the List of the friends the person follows
     */
    public void friendsWith(PersonNode friend) {
        if (friends == null) {
            friends = new ArrayList<PersonNode>();
        }
        friends.add(friend);
    }

    /**
     * Neo4j driver needs a no parameter constructor. Lombok generated sadly does not work
     */
    private PersonNode() { }

        --ArgsConstructors,Equal and HaschCode, ToString--
}

/**
 * ### Relations with properties
 */

/**
 * *@RelationshipProperties* can make a class into a relation with properties
 *
 */
@RelationshipProperties
@ToString
public class FriendRelation extends Persistable{

    @Property @Getter
    private LocalDate friendSince;

    /**
     * *@TargetNode* the node where the relation will point to.
     */
    @TargetNode @Getter
    private PersonNode person;

    private FriendRelation(){  }

    public FriendRelation(LocalDate friendSince, PersonNode person){

}

@Node("Person")
public class PersonNode extends Persistable{

    --properties--

    /**
     * Make the friend relation as a List of the FriendRelation class
     *
     * The output of this relation would look like this:
     *
     * <img src="./images/graphDia2.png" alt="graphImage2"/>
     *
     * The cool thing about that is, that the FOLLOWS relation stores data too
     * so that the person does not have to save a mass of data.
     */
    @Nullable @Getter
    @Relationship(type = "FOLLOWS")
    private List<FriendRelation> friends;

    public void friendsWith(FriendRelation friend) {
        if (friends == null) {
            friends = new ArrayList<FriendRelation>();
        }
        friends.add(friend);
    }

        --NoArgsConstructor,ArgsConstructors,Equal and HaschCode, ToString--
}


}

