package use.functionalj.maven.list;

import functionalj.lens.core.LensSpec;
import functionalj.lens.lenses.*;
import functionalj.pipeable.Pipeable;
import functionalj.result.Result;
import functionalj.types.Generated;
import functionalj.types.choice.ChoiceTypeSwitch;
import functionalj.types.choice.IChoice;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Generated(value = "FunctionalJ",date = "2021-06-28T15:31:28.663149", comments = "use.functionalj.gradle.TryChoice.TreeSpec")
@SuppressWarnings("all")
public abstract class Tree implements IChoice<Tree.TreeFirstSwitch>, Pipeable<Tree> {
    
    public static final Node Node(Object value, Tree left, Tree right) {
        return new Node(value, left, right);
    }
    public static final Leaf Leaf(Object value) {
        return new Leaf(value);
    }
    
    
    public static final TreeLens<Tree> theTree = new TreeLens<>(LensSpec.of(Tree.class));
    public static final TreeLens<Tree> eachTree = theTree;
    public static class TreeLens<HOST> extends ObjectLensImpl<HOST, Tree> {

        public final BooleanAccessPrimitive<Tree> isNode = Tree::isNode;
        public final BooleanAccessPrimitive<Tree> isLeaf = Tree::isLeaf;
        public final ResultAccess<HOST, Node, Node.NodeLens<HOST>> asNode = createSubResultLens(Tree::asNode, (functionalj.lens.core.WriteLens<Tree,Result<Node>>)null, Node.NodeLens::new);
        public final ResultAccess<HOST, Leaf, Leaf.LeafLens<HOST>> asLeaf = createSubResultLens(Tree::asLeaf, (functionalj.lens.core.WriteLens<Tree,Result<Leaf>>)null, Leaf.LeafLens::new);
        public TreeLens(LensSpec<HOST, Tree> spec) {
            super(spec);
        }
    }
    
    private Tree() {}
    public Tree __data() throws Exception { return this; }
    public Result<Tree> toResult() { return Result.valueOf(this); }
    
    public static <T extends Tree> T fromMap(java.util.Map<String, ? extends Object> map) {
        String __tagged = (String)map.get("__tagged");
        if ("Node".equals(__tagged))
            return (T)Node.caseFromMap(map);
        if ("Leaf".equals(__tagged))
            return (T)Leaf.caseFromMap(map);
        throw new IllegalArgumentException("Tagged value does not represent a valid type: " + __tagged);
    }
    
    static private functionalj.map.FuncMap<String, java.util.Map<String, functionalj.types.choice.generator.model.CaseParam>> __schema__ = functionalj.map.FuncMap.<String, java.util.Map<String, functionalj.types.choice.generator.model.CaseParam>>newMap()
        .with("Node", Node.getCaseSchema())
        .with("Leaf", Leaf.getCaseSchema())
        .build();
    public static java.util.Map<String, java.util.Map<String, functionalj.types.choice.generator.model.CaseParam>> getChoiceSchema() {
        return __schema__;
    }
    
    public static final class Node extends Tree {
        public static final Node.NodeLens<Node> theNode = new Node.NodeLens<>(LensSpec.of(Node.class));
        public static final Node.NodeLens<Node> eachNode = theNode;
        private Object value;
        private Tree left;
        private Tree right;
        private Node(Object value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public Object value() { return value; }
        public Tree left() { return left; }
        public Tree right() { return right; }
        public Node withValue(Object value) { return new Node(value, left, right); }
        public Node withLeft(Tree left) { return new Node(value, left, right); }
        public Node withRight(Tree right) { return new Node(value, left, right); }
        public static class NodeLens<HOST> extends ObjectLensImpl<HOST, Tree.Node> {
            
            public final ObjectLens<HOST, Object> value = (ObjectLens) createSubLens(Tree.Node::value, Tree.Node::withValue, ObjectLens::of);
            public final ObjectLens<HOST, Object> left = (ObjectLens)createSubLens(Tree.Node::left, Tree.Node::withLeft, ObjectLens::of);
            public final ObjectLens<HOST, Object> right = (ObjectLens)createSubLens(Tree.Node::right, Tree.Node::withRight, ObjectLens::of);
            
            public NodeLens(LensSpec<HOST, Tree.Node> spec) {
                super(spec);
            }
            
        }
        public java.util.Map<String, Object> __toMap() {
            java.util.Map<String, Object> map = new java.util.HashMap<>();
            map.put("__tagged", functionalj.types.IData.$utils.toMapValueObject("Node"));
            map.put("value", this.value);
            map.put("left", this.left);
            map.put("right", this.right);
            return map;
        }
        static private functionalj.map.FuncMap<String, functionalj.types.choice.generator.model.CaseParam> __schema__ = functionalj.map.FuncMap.<String, functionalj.types.choice.generator.model.CaseParam>newMap()
            .with("value", new functionalj.types.choice.generator.model.CaseParam("value", new functionalj.types.Type("java.lang", null, "Object", java.util.Collections.emptyList()), true, null))
            .with("left", new functionalj.types.choice.generator.model.CaseParam("left", new functionalj.types.Type("use.functionalj.gradle", null, "Tree", java.util.Collections.emptyList()), true, null))
            .with("right", new functionalj.types.choice.generator.model.CaseParam("right", new functionalj.types.Type("use.functionalj.gradle", null, "Tree", java.util.Collections.emptyList()), true, null))
            .build();
        public static java.util.Map<String, functionalj.types.choice.generator.model.CaseParam> getCaseSchema() {
            return __schema__;
        }
        public static Node caseFromMap(java.util.Map<String, ? extends Object> map) {
            return Node(
                $utils.propertyFromMap(map, __schema__, "value"),
                $utils.propertyFromMap(map, __schema__, "left"),
                $utils.propertyFromMap(map, __schema__, "right")
            );
        }
    }
    public static final class Leaf extends Tree {
        public static final Leaf.LeafLens<Leaf> theLeaf = new Leaf.LeafLens<>(LensSpec.of(Leaf.class));
        public static final Leaf.LeafLens<Leaf> eachLeaf = theLeaf;
        private Object value;
        private Leaf(Object value) {
            this.value = value;
        }
        public Object value() { return value; }
        public Leaf withValue(Object value) { return new Leaf(value); }
        public static class LeafLens<HOST> extends ObjectLensImpl<HOST, Tree.Leaf> {
            
            public final ObjectLens<HOST, Object> value = (ObjectLens) createSubLens(Tree.Leaf::value, Tree.Leaf::withValue, ObjectLens::of);
            
            public LeafLens(LensSpec<HOST, Tree.Leaf> spec) {
                super(spec);
            }
            
        }
        public java.util.Map<String, Object> __toMap() {
            java.util.Map<String, Object> map = new java.util.HashMap<>();
            map.put("__tagged", functionalj.types.IData.$utils.toMapValueObject("Leaf"));
            map.put("value", this.value);
            return map;
        }
        static private functionalj.map.FuncMap<String, functionalj.types.choice.generator.model.CaseParam> __schema__ = functionalj.map.FuncMap.<String, functionalj.types.choice.generator.model.CaseParam>newMap()
            .with("value", new functionalj.types.choice.generator.model.CaseParam("value", new functionalj.types.Type("java.lang", null, "Object", java.util.Collections.emptyList()), true, null))
            .build();
        public static java.util.Map<String, functionalj.types.choice.generator.model.CaseParam> getCaseSchema() {
            return __schema__;
        }
        public static Leaf caseFromMap(java.util.Map<String, ? extends Object> map) {
            return Leaf(
                $utils.propertyFromMap(map, __schema__, "value")
            );
        }
    }
    
    public java.util.Map<java.lang.String, java.util.Map<java.lang.String, functionalj.types.choice.generator.model.CaseParam>> __getSchema() {
        return getChoiceSchema();
    }
    
    private final TreeFirstSwitch __switch = new TreeFirstSwitch(this);
    @Override public TreeFirstSwitch match() {
         return __switch;
    }
    
    private volatile String toString = null;
    @Override
    public String toString() {
        if (toString != null)
            return toString;
        synchronized(this) {
            if (toString != null)
                return toString;
            toString = $utils.Match(this)
                    .node(node -> "Node(" + String.format("%1$s,%2$s,%3$s", node.value,node.left,node.right) + ")")
                    .leaf(leaf -> "Leaf(" + String.format("%1$s", leaf.value) + ")")
            ;
            return toString;
        }
    }
    
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tree))
            return false;
        
        if (this == obj)
            return true;
        
        String objToString  = obj.toString();
        String thisToString = this.toString();
        return thisToString.equals(objToString);
    }
    
    
    public boolean isNode() { return this instanceof Node; }
    public Result<Node> asNode() { return Result.valueOf(this).filter(Node.class).map(Node.class::cast); }
    public Tree ifNode(Consumer<Node> action) { if (isNode()) action.accept((Node)this); return this; }
    public Tree ifNode(Runnable action) { if (isNode()) action.run(); return this; }
    public boolean isLeaf() { return this instanceof Leaf; }
    public Result<Leaf> asLeaf() { return Result.valueOf(this).filter(Leaf.class).map(Leaf.class::cast); }
    public Tree ifLeaf(Consumer<Leaf> action) { if (isLeaf()) action.accept((Leaf)this); return this; }
    public Tree ifLeaf(Runnable action) { if (isLeaf()) action.run(); return this; }
    
    public static class TreeFirstSwitch {
        private Tree $value;
        private TreeFirstSwitch(Tree theValue) { this.$value = theValue; }
        public <TARGET> TreeFirstSwitchTyped<TARGET> toA(Class<TARGET> clzz) {
            return new TreeFirstSwitchTyped<TARGET>($value);
        }
        
        public <TARGET> TreeSwitchLeaf<TARGET> node(Function<? super Node, ? extends TARGET> theAction) {
            Function<Tree, TARGET> $action = null;
            Function<Tree, TARGET> oldAction = (Function<Tree, TARGET>)$action;
            Function<Tree, TARGET> newAction =
                ($action != null)
                ? oldAction : 
                    ($value instanceof Node)
                    ? (Function<Tree, TARGET>)(d -> theAction.apply((Node)d))
                    : oldAction;
            
            return new TreeSwitchLeaf<TARGET>($value, newAction);
        }
        public <TARGET> TreeSwitchLeaf<TARGET> node(Supplier<? extends TARGET> theSupplier) {
            return node(d->theSupplier.get());
        }
        public <TARGET> TreeSwitchLeaf<TARGET> node(TARGET theValue) {
            return node(d->theValue);
        }
        
        public <TARGET> TreeSwitchNodeLeaf<TARGET> node(java.util.function.Predicate<Node> check, Function<? super Node, ? extends TARGET> theAction) {
            Function<Tree, TARGET> $action = null;
            Function<Tree, TARGET> oldAction = (Function<Tree, TARGET>)$action;
            Function<Tree, TARGET> newAction =
                ($action != null)
                ? oldAction : 
                    (($value instanceof Node) && check.test((Node)$value))
                    ? (Function<Tree, TARGET>)(d -> theAction.apply((Node)d))
                    : oldAction;
            
            return new TreeSwitchNodeLeaf<TARGET>($value, newAction);
        }
        public <TARGET> TreeSwitchNodeLeaf<TARGET> node(java.util.function.Predicate<Node> check, Supplier<? extends TARGET> theSupplier) {
            return node(check, d->theSupplier.get());
        }
        public <TARGET> TreeSwitchNodeLeaf<TARGET> node(java.util.function.Predicate<Node> check, TARGET theValue) {
            return node(check, d->theValue);
        }
    }
    public static class TreeFirstSwitchTyped<TARGET> {
        private Tree $value;
        private TreeFirstSwitchTyped(Tree theValue) { this.$value = theValue; }
        
        public TreeSwitchLeaf<TARGET> node(Function<? super Node, ? extends TARGET> theAction) {
            Function<Tree, TARGET> $action = null;
            Function<Tree, TARGET> oldAction = (Function<Tree, TARGET>)$action;
            Function<Tree, TARGET> newAction =
                ($action != null)
                ? oldAction : 
                    ($value instanceof Node)
                    ? (Function<Tree, TARGET>)(d -> theAction.apply((Node)d))
                    : oldAction;
            
            return new TreeSwitchLeaf<TARGET>($value, newAction);
        }
        public TreeSwitchLeaf<TARGET> node(Supplier<? extends TARGET> theSupplier) {
            return node(d->theSupplier.get());
        }
        public TreeSwitchLeaf<TARGET> node(TARGET theValue) {
            return node(d->theValue);
        }
        
        public TreeSwitchNodeLeaf<TARGET> node(java.util.function.Predicate<Node> check, Function<? super Node, ? extends TARGET> theAction) {
            Function<Tree, TARGET> $action = null;
            Function<Tree, TARGET> oldAction = (Function<Tree, TARGET>)$action;
            Function<Tree, TARGET> newAction =
                ($action != null)
                ? oldAction : 
                    (($value instanceof Node) && check.test((Node)$value))
                    ? (Function<Tree, TARGET>)(d -> theAction.apply((Node)d))
                    : oldAction;
            
            return new TreeSwitchNodeLeaf<TARGET>($value, newAction);
        }
        public TreeSwitchNodeLeaf<TARGET> node(java.util.function.Predicate<Node> check, Supplier<? extends TARGET> theSupplier) {
            return node(check, d->theSupplier.get());
        }
        public TreeSwitchNodeLeaf<TARGET> node(java.util.function.Predicate<Node> check, TARGET theValue) {
            return node(check, d->theValue);
        }
    }
    public static class TreeSwitchNodeLeaf<TARGET> extends ChoiceTypeSwitch<Tree, TARGET> {
        private TreeSwitchNodeLeaf(Tree theValue, Function<Tree, ? extends TARGET> theAction) { super(theValue, theAction); }
        
        public TreeSwitchLeaf<TARGET> node(Function<? super Node, ? extends TARGET> theAction) {
            Function<Tree, TARGET> oldAction = (Function<Tree, TARGET>)$action;
            Function<Tree, TARGET> newAction =
                ($action != null)
                ? oldAction : 
                    ($value instanceof Node)
                    ? (Function<Tree, TARGET>)(d -> theAction.apply((Node)d))
                    : oldAction;
            
            return new TreeSwitchLeaf<TARGET>($value, newAction);
        }
        public TreeSwitchLeaf<TARGET> node(Supplier<? extends TARGET> theSupplier) {
            return node(d->theSupplier.get());
        }
        public TreeSwitchLeaf<TARGET> node(TARGET theValue) {
            return node(d->theValue);
        }
        
        public TreeSwitchNodeLeaf<TARGET> node(java.util.function.Predicate<Node> check, Function<? super Node, ? extends TARGET> theAction) {
            Function<Tree, TARGET> oldAction = (Function<Tree, TARGET>)$action;
            Function<Tree, TARGET> newAction =
                ($action != null)
                ? oldAction : 
                    (($value instanceof Node) && check.test((Node)$value))
                    ? (Function<Tree, TARGET>)(d -> theAction.apply((Node)d))
                    : oldAction;
            
            return new TreeSwitchNodeLeaf<TARGET>($value, newAction);
        }
        public TreeSwitchNodeLeaf<TARGET> node(java.util.function.Predicate<Node> check, Supplier<? extends TARGET> theSupplier) {
            return node(check, d->theSupplier.get());
        }
        public TreeSwitchNodeLeaf<TARGET> node(java.util.function.Predicate<Node> check, TARGET theValue) {
            return node(check, d->theValue);
        }
    }
    public static class TreeSwitchLeaf<TARGET> extends ChoiceTypeSwitch<Tree, TARGET> {
        private TreeSwitchLeaf(Tree theValue, Function<Tree, ? extends TARGET> theAction) { super(theValue, theAction); }
        
        public TARGET leaf(Function<? super Leaf, ? extends TARGET> theAction) {
            Function<Tree, TARGET> oldAction = (Function<Tree, TARGET>)$action;
            Function<Tree, TARGET> newAction =
                ($action != null)
                ? oldAction : 
                    ($value instanceof Leaf)
                    ? (Function<Tree, TARGET>)(d -> theAction.apply((Leaf)d))
                    : oldAction;
            
            return newAction.apply($value);
        }
        public TARGET leaf(Supplier<? extends TARGET> theSupplier) {
            return leaf(d->theSupplier.get());
        }
        public TARGET leaf(TARGET theValue) {
            return leaf(d->theValue);
        }
        
        public TreeSwitchLeaf<TARGET> leaf(java.util.function.Predicate<Leaf> check, Function<? super Leaf, ? extends TARGET> theAction) {
            Function<Tree, TARGET> oldAction = (Function<Tree, TARGET>)$action;
            Function<Tree, TARGET> newAction =
                ($action != null)
                ? oldAction : 
                    (($value instanceof Leaf) && check.test((Leaf)$value))
                    ? (Function<Tree, TARGET>)(d -> theAction.apply((Leaf)d))
                    : oldAction;
            
            return new TreeSwitchLeaf<TARGET>($value, newAction);
        }
        public TreeSwitchLeaf<TARGET> leaf(java.util.function.Predicate<Leaf> check, Supplier<? extends TARGET> theSupplier) {
            return leaf(check, d->theSupplier.get());
        }
        public TreeSwitchLeaf<TARGET> leaf(java.util.function.Predicate<Leaf> check, TARGET theValue) {
            return leaf(check, d->theValue);
        }
    }
    
    
    
}
