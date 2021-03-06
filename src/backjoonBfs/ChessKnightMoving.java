package backjoonBfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int x;
    int y;
    Node(int y, int x){
        this.x=x;
        this.y=y;
    }
}

public class ChessKnightMoving {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseNum = Integer.parseInt(br.readLine());
        Queue<Node> queue = new LinkedList<>();
        int[][] direction = {{-1,-2}, {-2,-1}, {-1,2}, {-2,1}, {1,-2}, {2,-1}, {2,1}, {1,2}};

        int N;
        boolean[][] visited ;
        int startY,startX,goalY,goalX;
        String[] kniteLoc,goalLoc;
        int moveCnt;
        boolean isDone;

        while(testCaseNum-->0){
            while(!queue.isEmpty()){
                queue.poll();
            }

            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];

            kniteLoc = br.readLine().split(" ");
            startY = Integer.parseInt(kniteLoc[0]);
            startX = Integer.parseInt(kniteLoc[1]);

            goalLoc = br.readLine().split(" ");
            goalY = Integer.parseInt(goalLoc[0]);
            goalX = Integer.parseInt(goalLoc[1]);

            queue.offer(new Node(startY,startX));
            visited[startY][startX] = true;

            moveCnt = -1;
            isDone = false;

            while(!queue.isEmpty()){
                if(isDone){
                    break;
                }

                int queueSize = queue.size();
                moveCnt++;
                for(int i=0;i<queueSize;i++){
                    Node presentNode = queue.poll();

                    if(presentNode.y==goalY && presentNode.x==goalX){
                        isDone=true;
                        break;
                    }

                    for(int j=0; j<8; j++){
                        int y = presentNode.y + direction[j][0];
                        int x = presentNode.x + direction[j][1];

                        if(x>=N || y>=N || x<0 || y<0){
                            continue;
                        }
                        if(visited[y][x]){
                            continue;
                        }

                        visited[y][x] = true;
                        queue.offer(new Node(y,x));
                    }
                }
            }

            bw.write(moveCnt+"\n");
        }

        br.close();
        bw.close();
    }
}
