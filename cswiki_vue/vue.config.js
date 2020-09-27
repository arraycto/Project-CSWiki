// 配置跨域支持
module.exports = {
    outputDir: "dist", //build输出目录
    assetsDir: "assets", //静态资源目录（js, css, img）
    lintOnSave: true, //是否开启eslint
    devServer: {
      open: true, //是否自动弹出浏览器页面
      host: "localhost",
      port: "8080", // Vue 运行端口
      https: false, //是否使用https协议
      hotOnly: true, //是否开启热更新
      proxy: { // 跨域支持
        "/api": {
          target: "http://localhost:8081", //API服务器的地址(后端）
          changeOrigin: true, // 虚拟的站点需要更管 origin
          pathRewrite: {
            //重写路径 比如 '/api/aaa/ccc'对应后端接口 '/aaa/ccc'
            "^/api": "",
          },
        },
      },
    },
  };
  