package org.simulation.pathfinding;

import org.simulation.core.Board;
import org.simulation.core.Position;

import java.util.*;

public class AStar {

    private final Board board;

    public AStar(Board board) {
        this.board = board;
    }

    public List<Position> find(Position start, Position target){
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(Node::getFCost));
        Set<Position> closedSet = new HashSet<>();

        Node startNode = new Node(start, 0, heuristic(start,target), null);
        openSet.add(startNode);

        while (!openSet.isEmpty()){
            Node current = openSet.poll();

            if (current.position.equals(target)){
                return reconstructPath(current);
            }

            closedSet.add(current.position);

            for (Position neighbor : getNeighbors(current.position, target)){
                if (closedSet.contains(neighbor)) continue;

                int tentativeGCost = current.gCost + 1;
                Node neighborNode = new Node(neighbor, tentativeGCost, heuristic(neighbor, target), current);

                boolean inOpenSet = openSet.stream()
                        .anyMatch(node -> node.position.equals(neighbor) && node.getFCost() <= neighborNode.getFCost());

                if (!inOpenSet){
                    openSet.add(neighborNode);
                }
            }

        }
        return Collections.emptyList();
    }

    private int heuristic(Position start, Position end){
        return Math.abs(start.getRow() - end.getRow()) + Math.abs(start.getCol() - end.getCol());
    }

    private List<Position> getNeighbors(Position current, Position target){
        List<Position> neighbors = new ArrayList<>();
        int[][] positions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] position : positions){
            int newRow = current.getRow() + position[0];
            int newCol = current.getCol() + position[1];
            Position neighbor = new Position(newCol, newRow);

            if (!board.isWithinBounds(neighbor)) continue;

            if (board.isPositionEmpty(neighbor) || neighbor.equals(target)){
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }

    private List<Position> reconstructPath(Node endNode){
        List<Position> path = new LinkedList<>();
        Node current = endNode;

        while (current != null){
            path.add(0, current.position);
            current = current.parent;
        }
        return path;
    }
}
