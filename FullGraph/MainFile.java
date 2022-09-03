import java.util.*;

public class MainFile {
    public static void main(String[] args) {
        ArrayList<String> rooms = new ArrayList<String>();
        VertexesList vertexes = new VertexesList();
        DirectedGraph myGraph = new DirectedGraph();
        Scanner in = new Scanner(System.in);
        int roomsValue;
        int weight = 0;
        int coo = 0;
        String vertex1;
        String vertex2;

        roomsValue = in.nextInt();
        for (int i = 0; i < roomsValue; i++) {
            rooms.add(in.next());
        }
        in.close();

        for (String rooms_iterator : rooms) {
            vertexes.addroom(rooms_iterator);
            while (true) {
                vertex1 = vertexes.removeVertex();
                myGraph.addVertex(vertex1);
                if (vertexes.getVertex() != null) {
                    vertex2 = vertexes.getVertex();
                    myGraph.addEdge(vertex1, vertex2);
                } else {
                    break;
                }
            }
        }

        Set<Map.Entry<String, List<String>>> vertexMap = myGraph.getVertexMap().entrySet();
        System.out.println(vertexMap.size());
        for (Map.Entry<String, List<String>> me : vertexMap) {
            List<String> edges = me.getValue();
            if (edges.size() != 0) {
                for (int i = 0; i < edges.size(); i++) {
                    while (i < (edges.size() - 1) && edges.get(i).equals(edges.get(i + 1))) {
                        i++;
                    }
                    coo++;
                }
            }
        }
        System.out.println(coo);
        for (Map.Entry<String, List<String>> me : vertexMap) {
            List<String> edges = me.getValue();
            if (edges.size() != 0) {
                for (int i = 0; i < edges.size(); i++) {
                    System.out.print(me.getKey() + " ");
                    weight = 1;
                    while (i < (edges.size() - 1) && edges.get(i).equals(edges.get(i + 1))) {
                        weight++;
                        i++;
                    }
                    System.out.print(edges.get(i) + " ");
                    System.out.println(weight);
                }
            }
        }
    }
}
