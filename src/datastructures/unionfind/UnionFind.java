package src.datastructures.unionfind;

public class UnionFind {

    // num of elements in union find
    private int size;
    // array to keep track of the parent of each component
    private int[] parent;
    // size of each component
    private int[] sz;

    private int numComponents;


    // constructor to initialize
    public UnionFind(int size) {

        if(size <=0) throw new IllegalArgumentException("Size much be greater than 0");

        this.size = numComponents = size;
        sz = new int[size];
        parent = new int[size];

        for(int i = 0; i < size; i++) {
            parent[i] = i; // initially each node itself is its root node
            sz[i] = 1; // size of each component initially is 1
        }

    }

    // find the component that p belongs to
    public int find(int p) {
    int root = p;
    while(root != parent[root]) {
        root = parent[root];
    }

    // this is path compression
    while(p != root) {
        int next = parent[p];
        parent[p] = root;
        p = next;
    }

    return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int componentSize(int p){
        return sz[find(p)];
    }

    public int size(){
        return size;
    }

    public int componentsCount(){
        return numComponents;
    }

    public void unify(int p, int q) {

        int root1 = find(p);
        int root2 = find(q);

        if(root1 == root2) return;

        if(sz[root1] < sz[root2]) {

            sz[root2] += sz[root1];
            parent[root1] = root2;
        }else{
            sz[root1] += sz[root2];
            parent[root2] = root1;
        }

        numComponents--;

    }


    public static void main(String[] args) {

        UnionFind uf = new UnionFind(10);
        System.out.println(uf.componentsCount());

        uf.unify(1, 2);
        System.out.println("num of components: "+uf.componentsCount());
        System.out.println("componentSize of: "+uf.componentSize(1));
        System.out.println("root of: "+uf.find(3));
        uf.unify(3, 4);
        System.out.println("root of: "+uf.find(3));
        uf.unify(1, 3);
        System.out.println("root of: "+uf.find(3));
        System.out.println("componentSize of: "+uf.componentSize(1));

        System.out.println("num of components: "+uf.componentsCount());
    }

}
