#include <iostream>
#include <queue>

/*
 *广度优先算法
 * */

using namespace std;
struct Node {
    Node * p;
    int x;
    int y;
    int level;
    Node() {}
    Node(int x, int y) : level(0), x(x), y(y), p(NULL) {}
};

/*打印最后的结果*/
void print(Node *top) {
    if (top->p != NULL) {
        print(top->p);    
    }
    cout << '(' << top->x << ',' << top->y << ')' << " ";
}

int main() {
    //3升水杯和4升水杯倒出五升水
    int a = 3, b = 4, target = 5;
    int x = 0, y = 0, k = 0;
    int xs[10], ys[10], i = 0;
    int mm[100] = {0};
    mm[0] = 1;
    queue<Node*> que;
    Node *top = new Node(0, 0);
    Node *next = NULL;
    que.push(top);
    while (!que.empty()) { 
        top = que.front();
        //最多操作20次
        if (top->level > 20) {
            break;
        }
        if (top->x + top->y == target) {
            print(top);
            cout << endl;
            que.pop();
            continue;
        }
#ifdef DEBUG
        cout << top->x << ' ' << top->y << endl;
#endif
        i = 0;
        que.pop();
        
        if (top->x == 0) {
            x = a;
            y = top->y;
            xs[i] = x;
            ys[i] = y;
            i++;
        }

        if (top->y == 0) {
            x = top->x;
            y = b;
            xs[i] = x;
            ys[i] = y;
            i++;
        }

        if (top->x == a) {
            x = 0;
            y = top->y;
            xs[i] = x;
            ys[i] = y;
            i++;
        }

        if (top->y == b) {
            x = top->x;
            y = 0;
            xs[i] = x;
            ys[i] = y;
            i++;
        }

        if (top->x != 0 && top->y != b) {
            x = top->x - ( b - top->y );
            if (x < 0) x = 0;
            y = top->y + top->x;
            if (y > b) y = b;
            xs[i] = x;
            ys[i] = y;
            i++;
        }

        if (top->y != 0 && top->x != a) {
            y = top->y - ( a - top->x );
            if (y < 0) y = 0;
            x = top->x + top->y;
            if (x > a) x = a;
            xs[i] = x;
            ys[i] = y;
            i++;
        }
        
#ifdef DEBUG
        cout << top->x << ' ' << top->y << ';';
#endif
        for (int j = 0; j < i; ++j) {
            x = xs[j];
            y = ys[j];
            k = x * 10 + y;
            if (mm[k] == 0) {
#ifdef DEBUG
            cout << x << ' ' << y << ',';
#endif
                next = new Node(x, y);
                next->level = top->level + 1;
                mm[k] = 1;
                next->p = top;
                que.push(next);
            }
        }
#ifdef DEBUG
        cout << endl;
#endif

    }
}
