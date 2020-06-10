
class Result {

static int[][][] dist;
static int[][] dp;
static List<int[]> coins;
static int R;
static int C;
static int allOnes, numCoins;
static int MAXDIST = 1000 * 1000;
static boolean isInRange(int r, int c) {
return r >= 0 && r < R && c >= 0 && c < C;
}
static void extractCoins(List<List<Integer>> arr, List<int[]> coins) {
for (int r = 0; r < R; r++) {
for (int c = 0; c < C; c++) {
if (arr.get(r).get(c) == 2) {
int[] point = {r, c};
coins.add(point);
}
}
}
}
static void setDistances(List<List<Integer>> arr, int coin) {
for (int r = 0; r < R; r++) {
for (int c = 0; c < C; c++) dist[r][c][coin] = MAXDIST;
}
boolean[][] visited = new boolean[R][C];
Queue<int[]> q = new LinkedList<>();
int[] startPoint = coins.get(coin);
q.add(startPoint);
visited[startPoint[0]][startPoint[1]] = true;
dist[startPoint[0]][startPoint[1]][coin] = 0;
int[] dr = {0, -1, 0, 1};
int[] dc = {-1, 0, 1, 0};
while (!q.isEmpty()) {
int[] point = q.poll();
int oldR = point[0];
int oldC = point[1];
for (int k = 0; k < 4; k++) {
int newR = oldR + dr[k];
int newC = oldC + dc[k];
if (isInRange(newR, newC) && !visited[newR][newC] && arr.get(newR).get(newC) != 1) {
int[] newPoint = {newR, newC};
visited[newR][newC] = true;
dist[newR][newC][coin] = dist[oldR][oldC][coin] + 1;
q.add(newPoint);
}
}
}
}
public static int minMoves(List<List<Integer>> maze, int x, int y) {
// Write your code here
R = maze.size();
C = maze.get(0).size();
int[] startPoint = {0, 0};
coins = new ArrayList<>();
coins.add(startPoint);
extractCoins(maze, coins);
numCoins = coins.size();
allOnes = (1 << numCoins) - 1;
int dpR = numCoins;
int dpC = allOnes + 1;
dp = new int[dpR][dpC];
for (int i = 0; i < dpR; i++) {
for (int j = 0; j < dpC; j++) dp[i][j] = -1;
}
dist = new int[R][C][numCoins];
for (int i = 0; i < numCoins; i++) setDistances(maze, i);
int ans = getMinDist(0, 1, x, y);
return ans >= MAXDIST ? -1 : ans;
}
static int getMinDist(int coin, int seq, int Ra, int Ca) {
if (seq == allOnes) return dist[Ra][Ca][coin];
if (dp[coin][seq] != -1) return dp[coin][seq];
int res = Integer.MAX_VALUE;
for (int i = 0; i < numCoins; i++) {
if ((seq & (1 << i)) == 0) {
int newSeq = seq | (1 << i);
int[] pos = coins.get(i);
res = Math.min(res, getMinDist(i, newSeq, Ra, Ca) + dist[pos[0]][pos[1]][coin]);
}
}
dp[coin][seq] = res;
return res;
}
}
