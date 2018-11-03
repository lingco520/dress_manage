
/**  默认加载  **/
$(function () {
    var  process={
        init:function(){
            this.swiper();
            this.public();
        },
        swiper:function () {
            /*  轮播效果加载   */
            var t=$(".swiper-wrapper img").length;
            if(t<2){
            }else {
                //首页加载
                $(".swiper-container").swiper({
                    loop: true,
                    autoplayDisableOnInteraction: false,
                    autoplay: 3000
                });
            }
        },
        public:function () {
            /** 上拉加载更多 **/
            $('.main').infinite().on("infinite", function () {
                $('#loading').show();
                setTimeout(function() {
                    var app='<a href="detail/index.html" class="img">'+
                        '<img src="public/images/list/c-1.jpg" />'+
                        '<div class="tag">'+
                        '<div class="title">'+
                        '<b>简花·单品鲜花月套餐</b>'+
                        '<i>¥800</i>'+
                        '</div>'+
                        '<div class="tips">一周一花，每月4次，精选一周当季花材，品种随机</div>'+
                        '</div>'+
                        '</a>'
                    for(var i=0; i<5;i++){
                        $('.contentList').append(app);
                    }
                    $('#loading').hide();
                },2000)
            });
        }
    };

    window.onload = function(){
        process.init();
    }


})
