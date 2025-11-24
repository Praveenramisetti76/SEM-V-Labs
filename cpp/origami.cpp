#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int area;
    cin >> area;
    
    int x1, y1, x2, y2;
    cin >> x1 >> y1 >> x2 >> y2;
    
    // Calculate side length of the square
    int side = (int)sqrt(area);
    
    // Initial corners of the square
    vector<pair<double, double>> corners = {
        {0, 0},
        {side, 0},
        {side, side},
        {0, side}
    };
    
    // The folding line goes from (x1, y1) to (x2, y2)
    // We need to reflect the left side of the folding line to the right side
    
    // For each corner, check which side of the folding line it's on
    // and reflect if necessary
    
    auto distToLine = [](double px, double py, double x1, double y1, double x2, double y2) -> double {
        // Calculate signed distance from point (px, py) to line (x1,y1)-(x2,y2)
        double dx = x2 - x1;
        double dy = y2 - y1;
        double num = abs(dy * px - dx * py + x2 * y1 - y2 * x1);
        double denom = sqrt(dx * dx + dy * dy);
        return num / denom;
    };
    
    auto whichSide = [](double px, double py, double x1, double y1, double x2, double y2) -> int {
        // Returns which side of the line the point is on
        // Positive = left, Negative = right, 0 = on line
        double val = (y2 - y1) * (px - x1) - (x2 - x1) * (py - y1);
        if (val > 1e-9) return 1;  // left
        if (val < -1e-9) return -1; // right
        return 0; // on line
    };
    
    auto reflectPoint = [](double px, double py, double x1, double y1, double x2, double y2) -> pair<double, double> {
        // Reflect point (px, py) across the line (x1,y1)-(x2,y2)
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
    };
    
    set<pair<double, double>> resultCorners;
    
    // Process each corner
    for (auto& corner : corners) {
        int side_val = whichSide(corner.first, corner.second, x1, y1, x2, y2);
        
        if (side_val <= 0) {
            // Right side - keep as is
            resultCorners.insert(corner);
        } else {
            // Left side - reflect it
            auto reflected = reflectPoint(corner.first, corner.second, x1, y1, x2, y2);
            resultCorners.insert(reflected);
        }
    }
    
    // Also add intersection points of folding line with square edges
    vector<pair<double, double>> intersections;
    
    // Check intersection with all 4 edges of the square
    auto checkIntersection = [](double x1, double y1, double x2, double y2, 
                                 double px1, double py1, double px2, double py2) -> pair<bool, pair<double, double>> {
        double x3 = x1, y3 = y1, x4 = x2, y4 = y2;
        double x5 = px1, y5 = py1, x6 = px2, y6 = py2;
        
        double denom = (x3 - x4) * (y5 - y6) - (y3 - y4) * (x5 - x6);
        if (abs(denom) < 1e-9) return {false, {0, 0}};
        
        double t = ((x3 - x5) * (y5 - y6) - (y3 - y5) * (x5 - x6)) / denom;
        double u = -((x3 - x4) * (y3 - y5) - (y3 - y4) * (x3 - x5)) / denom;
        
        if (t >= 0 && t <= 1 && u >= 0 && u <= 1) {
            double px = x3 + t * (x4 - x3);
            double py = y3 + t * (y4 - y3);
            return {true, {px, py}};
        }
        return {false, {0, 0}};
    };
    
    // Check with each edge of square
    vector<vector<double>> edges = {{0, 0, side, 0}, {side, 0, side, side}, 
                                           {side, side, 0, side}, {0, side, 0, 0}};
    
    for (auto& edge : edges) {
        pair<bool, pair<double, double>> result_pair = checkIntersection(x1, y1, x2, y2, edge[0], edge[1], edge[2], edge[3]);
        bool found = result_pair.first;
        pair<double, double> point = result_pair.second;
        if (found) {
            int side_val = whichSide(point.first, point.second, x1, y1, x2, y2);
            if (abs(side_val) < 1e-9) {
                resultCorners.insert(point);
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
