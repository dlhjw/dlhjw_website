(function($) {
    $("#input-b1").fileinput({
        language: 'zh', //设置语言
        uploadUrl: "/upload/mask", //上传的地址(访问接口地址)
        allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
        uploadAsync: true, //默认异步上传
        showUpload: true, //是否显示上传按钮
        showRemove: true, //显示移除按钮
        showPreview: true, //是否显示预览
        showCaption: true,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        dropZoneEnabled: true,//是否显示拖拽区域
//minImageWidth: 50, //图片的最小宽度
//minImageHeight: 50,//图片的最小高度
//maxImageWidth: 1000,//图片的最大宽度
//maxImageHeight: 1000,//图片的最大高度
//maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
        maxFileCount: 1, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',//加密类型
        validateInitialCount: true,//验证初始计数
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",//预览文件图标
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        dropZoneTitle: '拖拽图片到这里 &hellip;<br>后缀名为.jpg .gif .png ',
        dropZoneClickTitle: '<br>(或点击右下角按钮选择{files})',
        fileSingle: '图片',
    });
//异步上传返回错误结果处理
    $('#input-b1').on('fileerror', function (event, data, msg) {
        console.log(data.id);
        console.log(data.index);
        console.log(data.file);
        console.log(data.reader);
        console.log(data.files);
// get message
        alert(msg);
    });

    $("#input-b2").fileinput({
        language: 'zh', //设置语言
        uploadUrl: "/upload/pdfFile", //上传的地址(访问接口地址)
        allowedFileExtensions: ['pdf'],//接收的文件后缀
        uploadAsync: true, //默认异步上传
        showUpload: true, //是否显示上传按钮
        showRemove: true, //显示移除按钮
        showPreview: true, //是否显示预览
        showCaption: true,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        dropZoneEnabled: true,//是否显示拖拽区域
        maxFileSize: 10240,//单位为kb，如果为0表示不限制文件大小
        maxFileCount: 1, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',//加密类型
        validateInitialCount: true,//验证初始计数
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",//预览文件图标
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        dropZoneTitle: '拖拽相关文件到这里 &hellip;<br>后缀名为.pdf ',
        dropZoneClickTitle: '<br>(或点击右下角按钮选择{files})',
        fileSingle: '文件',
    });
//异步上传返回错误结果处理
    $('#input-b2').on('fileerror', function (event, data, msg) {
        console.log(data.id);
        console.log(data.index);
        console.log(data.file);
        console.log(data.reader);
        console.log(data.files);
        alert(msg);
    });


})(jQuery);

