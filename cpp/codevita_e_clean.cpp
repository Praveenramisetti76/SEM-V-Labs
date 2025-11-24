#include <bits/stdc++.h>
using namespace std;

struct Vec3 {
    int x,y,z;
    Vec3(int x_=0,int y_=0,int z_=0):x(x_),y(y_),z(z_){}
    Vec3 operator+(const Vec3& o) const { return Vec3(x+o.x,y+o.y,z+o.z); }
    Vec3 operator-(const Vec3& o) const { return Vec3(x-o.x,y-o.y,z-o.z); }
    Vec3 operator-() const { return Vec3(-x,-y,-z); }
    bool operator<(const Vec3& o) const {
        if(x!=o.x) return x<o.x;
        if(y!=o.y) return y<o.y;
        return z<o.z;
    }
    bool operator==(const Vec3& o) const { return x==o.x && y==o.y && z==o.z; }
};

Vec3 cross(const Vec3 &a, const Vec3 &b){
    return Vec3(a.y*b.z - a.z*b.y,
                a.z*b.x - a.x*b.z,
                a.x*b.y - a.y*b.x);
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    vector<string> grid;
    string line;
    for(int i=0;i<4;i++){
        if(!getline(cin, line)){
            return 0;
        }
        if((int)line.size() < 4){
            while((int)line.size() < 4) line.push_back('.');
        }
        grid.push_back(line);
    }
    string letters;
    if(!getline(cin, letters)) letters="";
    letters.erase(remove(letters.begin(), letters.end(), ' '), letters.end());
    letters.erase(remove(letters.begin(), letters.end(), '\r'), letters.end());
    letters.erase(remove(letters.begin(), letters.end(), '\n'), letters.end());

    string cornerFaces;
    if(!getline(cin, cornerFaces)) cornerFaces="";
    cornerFaces.erase(remove_if(cornerFaces.begin(), cornerFaces.end(), ::isspace), cornerFaces.end());

    vector<char> face_order;
    map<char, vector<pair<int,int>>> face_cells;
    for(int r=0;r<4;r++){
        for(int c=0;c<4;c++){
            char ch = (c < (int)grid[r].size()) ? grid[r][c] : '.';
            if(ch=='.') continue;
            if(face_cells.find(ch) == face_cells.end()){
                face_order.push_back(ch);
            }
            face_cells[ch].push_back({r,c});
        }
    }

    map<char, pair<int,int>> top_left;
    for(auto &kv: face_cells){
        char f = kv.first;
        auto &cells = kv.second;
        int rmin = INT_MAX, cmin = INT_MAX;
        for(auto &p: cells){
            rmin = min(rmin, p.first);
            cmin = min(cmin, p.second);
        }
        top_left[f] = {rmin, cmin};
    }

    map<char, string> face_chars;
    string s = letters;
    if((int)s.size() < 24){
        while((int)s.size() < 24) s.push_back('x');
    }
    for(size_t i=0;i<face_order.size();++i){
        char f = face_order[i];
        int idx = (int)i*4;
        if(idx+4 <= (int)s.size()){
            face_chars[f] = s.substr(idx,4);
        } else {
            string tmp="";
            for(int j=0;j<4;j++){
                if(idx+j < (int)s.size()) tmp.push_back(s[idx+j]);
                else tmp.push_back('x');
            }
            face_chars[f]=tmp;
        }
    }

    map<pair<int,int>, char> pos_to_face;
    for(auto &kv: top_left){
        pos_to_face[kv.second] = kv.first;
    }

    vector<pair<string,pair<int,int>>> dirs = {
        {"U", {-2, 0}},
        {"D", { 2, 0}},
        {"L", { 0,-2}},
        {"R", { 0, 2}}
    };

    if(face_order.empty()){
        return 0;
    }
    map<char, Vec3> normals, ups;
    char start = face_order[0];
    normals[start] = Vec3(0,0,1);
    ups[start] = Vec3(0,-1,0);

    queue<char> q;
    q.push(start);
    set<char> visited;
    visited.insert(start);
    while(!q.empty()){
        char f = q.front(); q.pop();
        auto rc = top_left[f];
        Vec3 n = normals[f];
        Vec3 u = ups[f];
        Vec3 rvec = cross(n,u);
        for(auto &d : dirs){
            string dir = d.first;
            int dr = d.second.first;
            int dc = d.second.second;
            pair<int,int> nbr_pos = {rc.first + dr, rc.second + dc};
            if(pos_to_face.find(nbr_pos) == pos_to_face.end()) continue;
            char g = pos_to_face[nbr_pos];
            if(normals.find(g) != normals.end()) continue;
            if(dir == "U"){
                normals[g] = u;
                ups[g] = Vec3(-n.x, -n.y, -n.z);
            } else if(dir == "D"){
                normals[g] = Vec3(-u.x, -u.y, -u.z);
                ups[g] = n;
            } else if(dir == "L"){
                normals[g] = Vec3(-rvec.x, -rvec.y, -rvec.z);
                ups[g] = u;
            } else if(dir == "R"){
                normals[g] = rvec;
                ups[g] = u;
            }
            q.push(g);
            visited.insert(g);
        }
    }

    map<Vec3, vector<pair<char,int>>> corner_map;
    for(char f : face_order){
        Vec3 n = normals[f];
        Vec3 u = ups[f];
        Vec3 rvec = cross(n,u);
        Vec3 corners_3d[4];
        corners_3d[0] = n - rvec - u;
        corners_3d[1] = n + rvec - u;
        corners_3d[2] = n - rvec + u;
        corners_3d[3] = n + rvec + u;
        
        for(int idx=0; idx<4; ++idx){
            corner_map[corners_3d[idx]].push_back({f, idx});
        }
    }

    vector<char> req;
    for(char c : cornerFaces){
        if(isalpha(c)) req.push_back(c);
        if(req.size() == 3) break;
    }
    if(req.size() != 3){
        while(req.size() < 3 && req.size() < face_order.size()){
            req.push_back(face_order[req.size()]);
        }
    }

    string result="";
    bool found = false;
    for(auto &kv: corner_map){
        auto &lst = kv.second;
        set<char> present;
        for(auto &p: lst) present.insert(p.first);
        bool ok = true;
        for(char need: req) if(present.find(need) == present.end()) ok = false;
        if(!ok) continue;
        for(char need: req){
            int chosen_idx = -1;
            for(auto &p: lst){
                if(p.first == need){
                    chosen_idx = p.second;
                    break;
                }
            }
            if(chosen_idx == -1){
                result.push_back('?');
            } else {
                string fc = face_chars[need];
                if((int)fc.size() == 4){
                    result.push_back(fc[chosen_idx]);
                } else {
                    result.push_back('?');
                }
            }
        }
        found = true;
        break;
    }

    if(!found){
        cout << "???\n";
    } else {
        cout << result << "\n";
    }

    return 0;
}
