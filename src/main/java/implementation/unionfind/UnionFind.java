package implementation.unionfind;

public class UnionFind {
    private static class Vertex {
        private int val;
        private int size;
        private Vertex parent;

        public Vertex(int val) {
            this.val = val;
            this.parent = this;
        }
    }

    public boolean find(Vertex p, Vertex q) {
        return getRoot(p) == getRoot(q);
    }

    public void union(Vertex p, Vertex q) {
        Vertex pRoot = getRoot(p);
        Vertex qRoot = getRoot(q);
        // union smaller tree to larger
        if (pRoot.size < qRoot.size) { // p -> q
            pRoot.parent = qRoot;
            qRoot.size += pRoot.size;
        } else { // q -> p
            qRoot.parent = pRoot;
            pRoot.size += qRoot.size;
        }
    }

    private Vertex getRoot(Vertex p) {
        Vertex cur = p;
        while (cur.parent != cur) {
            cur.parent = cur.parent.parent; // path compression
            cur = cur.parent; // move cur pointer
        }
        p.parent = cur;
        return cur;
    }
}