namespace java com.cutejiuge.base

struct TrafficEnv {
    1: bool open = false;
    2: string env = "";
}

struct Base {
    1: string logID = "";
    2: string caller = "";
    3: string addr = "";
    4: string client = "";
    5: optional TrafficEnv trafficEnv;
    6: optional map<string, string> extra;
}

struct BaseResp {
    1: string statusMessage = "";
    2: i32 statusCode = 0;
    3: optional map<string, string> extra;
}