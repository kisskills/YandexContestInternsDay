package old;

import java.util.LinkedList;

public class VertexesList {
    private String room;
    private LinkedList<String> vertexes = new LinkedList<String>();

    public VertexesList() {
        room = "";
    }

    public VertexesList(String room) {
        this.room = room;
        roomToVertexes();
    }

    public void addroom(String room) {
        this.room = room;
        vertexes.clear();
        roomToVertexes();
    }

    public String removeVertex() {
        return vertexes.isEmpty() ? null : vertexes.removeFirst();
    }

    public String getVertex() {
        return vertexes.isEmpty() ? null : vertexes.getFirst();
    }

    public void printVertexList() {
        for (String vert : vertexes) {
            System.out.print(vert + "->");
        }
        System.out.println();
    }

    private void roomToVertexes() {
        for (int i = 0; i < room.length() - 2; i++) {
            vertexes.add(room.substring(i, i + 3));
        }
    }
}
