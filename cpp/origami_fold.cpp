#include <bits/stdc++.h>
using namespace std;

const double EPS = 1e-9;

int whichSide(double px, double py, double x1, double y1, double x2, double y2) {
    double val = (y2 - y1) * (px - x1) - (x2 - x1) * (py - y1);
    if (val > EPS) return 1;   // left
    if (val < -EPS) return -1; // right
    return 0; // on line
}

pair<double, double> reflectPoint(double px, double py, double x1, double y1, double x2, double y2) {
    double dx = x2 - x1;
    double dy = y2 - y1;
    double a = dy;
    double b = -dx;
    double c = -(a * x1 + b * y1);
    
    double denom = a * a + b * b;
    double t = -(a * px + b * py + c) / denom;
    
    double rx = px + 2 * a * t;
    double ry = py + 2 * b * t;
    
    return {rx, ry};
}

pair<bool, pair<double, double>> lineIntersection(double x1, double y1, double x2, double y2,
                                                   double px1, double py1, double px2, double py2) {
    double x3 = x1, y3 = y1, x4 = x2, y4 = y2;
    double x5 = px1, y5 = py1, x6 = px2, y6 = py2;
    
    double denom = (x3 - x4) * (y5 - y6) - (y3 - y4) * (x5 - x6);
    if (abs(denom) < EPS) return {false, {0, 0}};
    
    double t = ((x3 - x5) * (y5 - y6) - (y3 - y5) * (x5 - x6)) / denom;
    double u = -((x3 - x4) * (y3 - y5) - (y3 - y4) * (x3 - x5)) / denom;
    
    if (t >= -EPS && t <= 1 + EPS && u >= -EPS && u <= 1 + EPS) {
        double px = x3 + t * (x4 - x3);
        double py = y3 + t * (y4 - y3);
        return {true, {px, py}};
    }
    return {false, {0, 0}};
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int area;
    cin >> area;
    
    double x1, y1, x2, y2;
    cin >> x1 >> y1 >> x2 >> y2;
    
    int side = (int)sqrt(area);
    
    vector<pair<double, double>> corners = {
        {0, 0},
        {(double)side, 0},
        {(double)side, (double)side},
        {0, (double)side}
    };
    
    set<pair<double, double>> resultCorners;
    
    // Process each corner
    for (auto& corner : corners) {
        int s = whichSide(corner.first, corner.second, x1, y1, x2, y2);
        
        if (s <= 0) {
            // Right side - keep as is
            resultCorners.insert(corner);
        } else {
            // Left side - reflect it
            auto reflected = reflectPoint(corner.first, corner.second, x1, y1, x2, y2);
            resultCorners.insert(reflected);
        }
    }
    
    // Check intersections with square edges
    vector<vector<double>> edges = {
        {0, 0, (double)side, 0},
        {(double)side, 0, (double)side, (double)side},
        {(double)side, (double)side, 0, (double)side},
        {0, (double)side, 0, 0}
    };
    
    for (int i = 0; i < 4; i++) {
        auto result_pair = lineIntersection(x1, y1, x2, y2, edges[i][0], edges[i][1], edges[i][2], edges[i][3]);
        if (result_pair.first) {
            double px = result_pair.second.first;
            double py = result_pair.second.second;
            int s = whichSide(px, py, x1, y1, x2, y2);
            if (abs(s) < EPS) {
                resultCorners.insert({px, py});
            }
        }
    }
    
    // Convert to vector and sort
    vector<pair<double, double>> result(resultCorners.begin(), resultCorners.end());
    sort(result.begin(), result.end());
    
    cout << result.size() << "\n";
    cout << fixed << setprecision(2);
    for (auto& p : result) {
        cout << p.first << " " << p.second << "\n";
    }
    
    return 0;
}
