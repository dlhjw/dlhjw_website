const v1 = new Vue({
    el: "#main",
    data: {

        title: "正在生成主页...",
        result: "",
        companyMess: "公司名称",
        urlD2: '',
        urlD8: '',
        edus: new Array(),
        works: new Array(),
        honours: new Array(),
        user: {
            uid: 0,
            name: "",
            birth: "",
            political: "",
            city: "",
            address: "",
            sex: 0,
            isMessage: 0,
            info: ""
        },
        contact: {
            cid: 0,
            email: "",
            phone: "",
            wechat: "",
            wechatOfficial: "",
            qq: "",
            weibo: "",
            github: "",
            blog: "",
        },
        edu: {
            eid: 0,
            school: "",
            study: "",
            start: "",
            end: "",
            description: ""
        },
        work: {
            wid: 0,
            isSchool: 0,
            company: "",
            job: "",
            start: "",
            end: "",
            description: ""
        },
        keywords: {
            kid: 0,
            disposition: "",
            ability: ""
        },
        specialty1: {
            sid: 0,
            name: "",
            description: ""
        },
        specialty2: {
            sid: 0,
            name: "",
            description: ""
        },
        honour: {
            hid: 0,
            category: 0,
            name: "",
            description: "",
            haveFile: 0,
            fileCode: -1,
            file: ""
        },
        //count用来标记特长数量
        count: 0
    },
    methods: {
        nan: function() { this.user.sex = 1; },
        nv: function() { this.user.sex = 0; },
        mssOpen: function() { this.user.isMessage = 1; },
        mssClose: function() { this.user.isMessage = 0; },
        schNo: function() { v1.work.isSchool = 0; v1.companyMess = "公司名称"; },
        schYes: function() { v1.work.isSchool = 1; v1.companyMess = "组织名称";},
        category0: function() { this.honour.category = 0; },
        category1: function() { this.honour.category = 1; },
        category2: function() { this.honour.category = 2; },
        fileNo: function(){ this.honour.haveFile = 0; },
        fileYes: function(){ this.honour.haveFile = 1; },
        //1.提交用户基础信息
        userClick: function() {
            //将跳转地址清零
            v1.urlD2 = "";
            v1.urlD8 = "";
            if( v1.user.name === ""){
                console.log("名字空");
                layer.msg("至少需要填写姓名才能生成哦");
                return;
            }
            //如果名字不为空，才能进行跳转与储存
            v1.urlD2 = "#d2";
            v1.urlD8 = "#d8";
            if(v1.user.uid === 0){
                //弹窗信息
                let index = layer.msg("用户基本信息生成中...", { icon: 16 });
                //发送post请求，后端返回result型json字符串：res
                this.$http.post("/user", v1.user, { "emulateJSON": true }).then(function(res) {
                    //在控制台调试数据 F12-Console
                    console.log(res.body);
                    //赋值
                    v1.user.uid = res.body.data;
                    //关闭自身弹窗
                    layer.close(index);
                    //前端反映后端信息 “用户创建成功”
                    layer.msg(res.body.msg);
                }, function(res) {
                    //alert错误信息
                    alert("用户信息提交失败，请联系开发者或重试");
                    //关闭自身弹窗
                    layer.close(index);
                    //访问失败
                    layer.msg("用户创建失败");
                });
            } else {
                let index = layer.msg("信息更新中...", { icon: 16 });
                this.$http.put("/user", v1.user, { "emulateJSON": true }).then(function(res) {
                    console.log(res.body);
                    v1.user.uid = res.body.data;
                    layer.close(index);
                    layer.msg(res.body.msg);
                }, function(res) {
                    alert("信息更新失败，请重试或联系开发者");
                    layer.close(index);
                    layer.msg(res.body.msg);
                });
            }
        },
        contactClick: function() {
            //录入uid
            v1.contact.uid = v1.user.uid;
            console.log("mack=" + v1.contact.mask)
        },
        saveEdu: function() {
            //录入uid
            v1.edu.uid = v1.user.uid;
            //存储学习信息到edus
            v1.edus.push(Object.assign({}, v1.edu));
            v1.edu.eid = 0;
            v1.edu.school = "";
            v1.edu.study = "";
            v1.edu.start = "";
            v1.edu.end = "";
            v1.edu.description = "";
        },
        eduClick: function() {
            //录入uid
            v1.edu.uid = v1.user.uid;
            //存储学习信息到edus
            v1.edus.push(Object.assign({}, v1.edu));
        },
        saveWork: function() {
            //录入uid
            v1.work.uid = v1.user.uid;
            // 存储工作信息到works
            v1.works.push(Object.assign({}, v1.work));
            v1.work.wid = 0;
            v1.work.company = "";
            v1.work.job = "";
            v1.work.start = "";
            v1.work.end = "";
            v1.work.description = "";
        },
        backEdu: function() {
            v1.edus = new Array();
        },
        workClick: function() {
            //录入uid
            v1.work.uid = v1.user.uid;
            // 存储工作信息到works
            v1.works.push(Object.assign({}, v1.work));
        },
        backWork: function() {
            v1.works = new Array();
        },
        keywordsClick: function() {
            v1.keywords.uid = v1.user.uid;
        },
        specialtyClick: function() {
            v1.specialty.uid = v1.user.uid;
        },
        saveHonour: function() {
            //录入uid
            v1.honour.uid = v1.user.uid;
            if(v1.honour.haveFile !== 0){
                v1.honour.fileCode++;
            }
            console.log(v1.honour.fileCode);
            // 存储工作信息到works
            v1.honours.push(Object.assign({}, v1.honour));
            v1.honour.hid = 0;
            v1.honour.name = "";
            v1.honour.description = "";
            v1.honour.haveFile = 0;
            // 清除radio状态

        },
        backHonour: function() {
            v1.honours = new Array();
        },
        honourClick: function() {
            //录入uid
            v1.honour.uid = v1.user.uid;
            if(v1.honour.haveFile !== 0){
                v1.honour.fileCode++;
            }
            // 存储荣誉信息到honour
            v1.honours.push(Object.assign({}, v1.honour));
        },

        endClick: function() {
            v1.contact.uid = v1.user.uid;
            v1.edu.uid = v1.user.uid;
            if( v1.edus.length === 0){
                v1.edus.push(Object.assign({}, v1.edu));
            }
            v1.work.uid = v1.user.uid;
            if( v1.works.length === 0){
                v1.works.push(Object.assign({}, v1.work));
            }
            v1.honour.uid = v1.user.uid;
            if( v1.honours.length === 0){
                v1.honours.push(Object.assign({}, v1.honour));
            }
            v1.keywords.uid = v1.user.uid;
            v1.specialty.uid = v1.user.uid;
        },
        userEndClick: function() {
            v1.userClick();
            v1.endClick();

        },
        submitClick: function() {
            //录入specialty1和specialty2的uid
            v1.specialty1.uid = v1.user.uid;
            v1.specialty2.uid = v1.user.uid;
            //依次提交数据
            //x1用来判断第x1+1个循环体
            let x1 = 0;
            v1.result = "提交联系方式中...";
            this.$http.post("/contact", v1.contact, { "emulateJSON": true }).then(function(res) {
                console.log(res.body);

                //提交教育经历
                for (i = 0; i < v1.edus.length; i++) {
                    v1.result = "提交教育经历中...";
                    this.$http.post("/education", v1.edus[i], { "emulateJSON": true }).then(function(res) {
                        console.log(res.body);
                        console.log("第i个教育经历：" + i);
                        console.log("共有教育经历个数" + v1.edus.length);
                        if (x1 === 0) {
                            x1++;

                            //提交工作经历
                            v1.result = "提交工作经历中...";
                            console.log("共有工作经历个数" + v1.works.length);
                            for (i = 0; i < v1.works.length; i++) {
                                this.$http.post("/work", v1.works[i], { "emulateJSON": true }).then(function(res) {
                                    console.log(res.body);
                                    console.log("第i个工作经历：" + i);

                                    if (x1 === 1) {
                                        x1++;

                                        //提交关键词
                                        v1.result = "提交关键词中...";
                                        this.$http.post("/keywords", v1.keywords, { "emulateJSON": true }).then(function(res) {
                                            console.log(res.body);

                                            //提交特长一
                                            v1.result = "提交特长中...";
                                            this.$http.post("/specialty", v1.specialty1, { "emulateJSON": true }).then(function(res) {
                                                console.log(res.body);
                                                console.log("提交第一个特长");
                                                v1.count++;
                                                if (v1.count === 2) {
                                                    if (x1 === 2) {
                                                        x1++;
                                                        //提交荣誉证书
                                                        for (i = 0; i < v1.honours.length; i++) {
                                                            v1.result = "提交荣誉证书中...";
                                                            this.$http.post("/honour", v1.honours[i], { "emulateJSON": true }).then(function(res) {
                                                                console.log(res.body);
                                                                console.log("第i个荣誉证书：" + i);
                                                                console.log("荣誉证书个数：" + v1.honours.length);

                                                                if (i === v1.honours.length) {
                                                                    console.log("请求进来了");
                                                                    v1.title = "生成成功：";
                                                                    v1.result = "<strong>您的专属id是：" + v1.user.uid + " </strong>（请牢记） <br><br> 点击下方链接访问(或复制到浏览器打开)：<br><br> <a href='info/" + v1.user.uid + "'>http://47.106.67.138/info/" + v1.user.uid + " </a>"

                                                                }

                                                            }, function(res) {
                                                                alert("荣誉证书提交失败，请重试或联系开发者");
                                                                v1.result = "提交荣誉证书失败";
                                                            });
                                                        }
                                                    }
                                                }
                                            }, function(res) {
                                                alert("特长一提交失败，请重试或联系开发者");
                                                v1.result = "提交特长一失败";
                                            });
                                            //提交特长二
                                            this.$http.post("/specialty", v1.specialty2, { "emulateJSON": true }).then(function(res) {
                                                console.log(res.body);
                                                console.log("提交第二个特长");
                                                v1.count++;
                                                console.log("count=" + v1.count);
                                                if (v1.count === 2) {
                                                    if (x1 === 2) {
                                                        x1++;
                                                        //提交荣誉证书
                                                        for (i = 0; i < v1.honours.length; i++) {
                                                            v1.result = "提交荣誉证书中...";
                                                            this.$http.post("/honour", v1.honours[i], { "emulateJSON": true }).then(function(res) {
                                                                console.log(res.body);
                                                                console.log("第i个荣誉证书：" + i);
                                                                console.log("荣誉证书个数：" + v1.honours.length);
                                                                if (i === v1.honours.length) {
                                                                    v1.title = "生成成功：";
                                                                    v1.result = "<strong>您的专属id是：" + v1.user.uid + " </strong>（请牢记） <br><br> 点击下方链接访问(或复制到浏览器打开)：<br><br> <a href='info/" + v1.user.uid + "'><strong>http://47.106.67.138/info/" + v1.user.uid + " </strong></a>"
                                                                }
                                                            }, function(res) {
                                                                alert("荣誉证书提交失败，请重试或联系开发者");
                                                                v1.result = "提交荣誉证书失败";
                                                            });
                                                        }
                                                    }
                                                }
                                            }, function(res) {
                                                alert("特长二提交失败，请重试或联系开发者");
                                                layer.close(index);
                                                v1.result = "提交特长二失败";
                                            });
                                        }, function(res) {
                                            alert("关键词提交失败，请重试或联系开发者");
                                            v1.result = "提交关键词失败";
                                        });
                                    }
                                }, function(res) {
                                    alert("工作经历提交失败，请重试或联系开发者");
                                    v1.result = "提交工作经历失败";
                                });
                            }

                        }
                    }, function(res) {
                        alert("学习经历提交失败，请重试或联系开发者");
                        v1.result = "提交学习经历失败";
                    });
                }



            }, function(res) {
                alert("联系方式提交失败，请重试或联系开发者");
                v1.result = "提交联系方式失败";
            });
        }
    }
});