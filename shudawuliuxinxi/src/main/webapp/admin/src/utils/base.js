const base = {
    get() {
        return {
            url : "http://localhost:8080/shudawuliuxinxi/",
            name: "shudawuliuxinxi",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/shudawuliuxinxi/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "速达物流信息查询"
        } 
    }
}
export default base
