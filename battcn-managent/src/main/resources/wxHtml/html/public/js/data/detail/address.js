
/**  默认加载  **/
$(function () {
    var  process={
        init:function(){
            this.public();
        },
        public:function () {
            /** 加载城市选择  **/
            $("#start").cityPicker({
                title: "选择出发地",
                onChange: function (picker, values, displayValues) {
                    console.log(values, displayValues);
                }
            });
            /** 加载城市选择  **/
            $(".order").click(function(){
                var name=$("#name").val()
                var phone=$("#phone").val();
                var area=$("#start").val()
                var address=$("#address").val()
                if(!isNull(name,phone,area,address)) return;
                if(!isPhone(phone)) return;
                window.location.href='order-address.html';
            });
        }
    };

    window.onload = function(){
        process.init();
    }


})


/**
 * 非空校验
 * @param value
 * @returns {*}
 */

function isNull(name,phone,area,address) {
   if(name==''||phone==''||area==''||address==''){
       $.alert('输入内容不能为空');
       return false
   }
   else{
       return true;
   }

}

/**
 * 手机号码校验
 * @param value
 * @returns {*}
 */

function isPhone(value) {
    var phone = value;
    var patterns = /^1[3,5,8,7,4]\d{9}$/;
    if (!patterns.test(phone)) {
        $.alert('手机号码错误');
        return false;
    }
    return true;

}