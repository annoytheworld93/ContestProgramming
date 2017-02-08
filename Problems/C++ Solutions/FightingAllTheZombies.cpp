// Hacker Cup 2017
// Round 2
// Fighting all the Zombies
// Jacob Plachta
  
#include <algorithm>
#include <functional>
#include <numeric>
#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cmath>
#include <complex>
#include <cstdlib>
#include <ctime>
#include <cstring>
#include <cassert>
#include <string>
#include <vector>
#include <list>
#include <map>
#include <set>
#include <deque>
#include <queue>
#include <stack>
#include <bitset>
#include <sstream>
using namespace std;
  
#define LL long long
#define LD long double
#define PR pair<int,int>
  
#define Fox(i,n) for (i=0; i<n; i++)
#define Fox1(i,n) for (i=1; i<=n; i++)
#define FoxI(i,a,b) for (i=a; i<=b; i++)
#define FoxR(i,n) for (i=(n)-1; i>=0; i--)
#define FoxR1(i,n) for (i=n; i>0; i--)
#define FoxRI(i,a,b) for (i=b; i>=a; i--)
#define Foxen(i,s) for (i=s.begin(); i!=s.end(); i++)
#define Min(a,b) a=min(a,b)
#define Max(a,b) a=max(a,b)
#define Sz(s) int((s).size())
#define All(s) (s).begin(),(s).end()
#define Fill(s,v) memset(s,v,sizeof(s))
#define pb push_back
#define mp make_pair
#define x first
#define y second
  
template<typename T> T Abs(T x) { return(x<0 ? -x : x); }
template<typename T> T Sqr(T x) { return(x*x); }
  
const int INF = (int)1e9;
const LD EPS = 1e-9;
const LD PI = acos(-1.0);
  
bool Read(int &x)
{
    char c,r=0,n=0;
    x=0;
        for(;;)
        {
            c=getchar();
                if ((c<0) && (!r))
                    return(0);
                if ((c=='-') && (!r))
                    n=1;
                else
                if ((c>='0') && (c<='9'))
                    x=x*10+c-'0',r=1;
                else
                if (r)
                    break;
        }
        if (n)
            x=-x;
    return(1);
}
  
#define LIM 2100000
#define MOD 1000000007
  
int sz,tree[LIM][2][2];
int V1[LIM],V2[LIM],V3[LIM];
  
void Add(int &a,int b)
{
    a+=b;
        if (a>=MOD)
            a-=MOD;
}
  
void Calc(int i)
{
        if (i>=sz)
        {
            tree[i][0][0]=V1[i-sz];
            tree[i][0][1]=(LL)V2[i-sz]*V3[i-sz]%MOD;
            tree[i][1][0]=1;
            tree[i][1][1]=0;
            return;
        }
    int j=i<<1,k=j+1,a,b,c;
    Fill(tree[i],0);
        Fox(a,2)
            Fox(b,2)
                Fox(c,2)
                    Add(tree[i][a][b],(LL)tree[j][a][c]*tree[k][c][b]%MOD);
}
  
int main()
{
    int T,t;
    int N,M,Z;
    int W,Aw,Bw;
    int D,Ad,Bd;
    int S,As,Bs;
    int i,tot;
    Read(T);
        Fox1(t,T)
        {
            Read(N),Read(M);
            Read(W),Read(Aw),Read(Bw);
            Read(D),Read(Ad),Read(Bd);
            Read(S),Read(As),Read(Bs);
                for(sz=1;sz<N;sz<<=1);
                Fox(i,sz)
                    V1[i]=1;
            Fill(V2,0);
            Fill(V3,0);
                FoxR1(i,(sz<<1)-1)
                    Calc(i);
            tot=0;
                while (M--)
                {
                    Z=max(1,min(N,W+D-1));
                        if (W==Z)
                            Add(V1[W-1],S);
                        else
                        if (W<Z)
                            Add(V2[W-1],S);
                        else
                            Add(V3[Z-1],S);
                    i=min(W-1,Z-1)+sz;
                        while (i)
                            Calc(i),i>>=1;
                    Add(tot,tree[1][0][0]);
                    W=((LL)Aw*W+Bw)%N+1;
                    D=((LL)Ad*D+Bd)%3;
                    S=((LL)As*S+Bs)%INF+1;
                }
            printf("Case #%d: %d\n",t,tot);
        }
    return(0);
}
