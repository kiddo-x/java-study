


int[] myQueue = new int [10000000];
int front = 5000000;
int rear = 5000000;

static void enqueue(int value) myQueue[rear++] = value;
static void dequeue() front++;
static int peek() return myQueue[front];
static boolean isEmpty() return front == rear; 