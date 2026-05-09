//TASK 1

//Visit A — marked: [A]
//first unvisited neighbor: C
//Visit C — marked: [A, C]
//A is already marked, skip
//first unvisited neighbor: B
//Visit B — marked: [A, C, B]
//A is already marked, skip
//C is already marked, skip
//first unvisited neighbor: E
//Visit E — marked: [A, C, B, E]
//first unvisited neighbor: G
//Visit G — marked: [A, C, B, E, G]
//first unvisited neighbor: F
//Visit F — marked: [A, C, B, E, G, F]
//G is already marked, skip
//E is already marked, skip
//no unvisited neighbors, backtrack to G
//Back at G
//B is already marked, skip
//no unvisited neighbors, backtrack to E
//Back at E
//F is already marked, skip
//B is already marked, skip
//no unvisited neighbors, backtrack to B
//Back at B
//G is already marked, skip
//no unvisited neighbors, backtrack to C
//Back at C
//first unvisited neighbor: D
//Visit D — marked: [A, C, B, E, G, F, D]
//C is already marked, skip
//A is already marked, skip
//no unvisited neighbors, search complete
//DFS traversal order: A - C - B - E - G - F - D