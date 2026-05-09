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



//TASK 2

//Visit A — marked: [A]
//enqueue neighbors: C, B, D
//queue: [C, B, D]
//Dequeue C — marked: [A, C]
//A is already marked, skip
//B is already marked, skip
//D is already marked, skip
//queue: [B, D]
//Dequeue B — marked: [A, C, B]
//A is already marked, skip
//C is already marked, skip
//enqueue E
//enqueue G
//queue: [D, E, G]
//Dequeue D — marked: [A, C, B, D]
//C is already marked, skip
//A is already marked, skip
//queue: [E, G]
//Dequeue E — marked: [A, C, B, D, E]
//G is already marked, skip
//enqueue F
//B is already marked, skip
//queue: [G, F]
//Dequeue G — marked: [A, C, B, D, E, G]
//F is already marked, skip
//B is already marked, skip
//queue: [F]
//Dequeue F — marked: [A, C, B, D, E, G, F]
//G is already marked, skip
//E is already marked, skip
//queue: []
//no more vertices, search complete
//BFS traversal order: A - C - B - D - E - G - F