import axios from "axios";

//定义后端接口地址前缀
axios.defaults.baseURL = "http://localhost:8089";

//导出封装函数
export function doGet(url,params){
    axios({
        method: 'get',
        url: url,
        params: params,//参数{name: "对的", age: 22},
        dataType:"json"
      // }).then(function (rep) :void{
      //   var s:string = "";
      //     rep.data.forEach(function(stu) :void){
      //       s += stu.name + "----------------" stu.age + ''
      //     }
        })
}

export function doPost(url,data){
    // 发起一个post请求
  return axios({
    method: 'post',
    url: url,
    data:data,//参数
    dataType:"json"
  })
}

export function doPut(url,data){
  // 发起一个post请求
axios({
  method: 'post',
  url: url,
  data:data,//参数

});
}

// export function doDelete(url,params){
//   axios({
//       method: 'get',
//       url: url,
//       params: params,//参数{name: "对的", age: 22},
//       dataType:"json"
//     }).then(function (rep) :void{
//       var s:string = "";
//         rep.data.forEach(function(stu):void){
//           s += stu.name + "----------------" stu.age + ''
//         }
//       });
// }