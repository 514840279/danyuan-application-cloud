// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'


Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({

  //这里可以用created或mounted
  mounted() {
    this.submitForm()
  },
  methods: {
    submitForm() {     
      
     
    }
  }
})
$(function (){
  $.ajax({
    url: 'http://localhost:81/crawler/sysMenuInfo/findzTreeByUser',
    type: 'POST',
    dataType: 'json',
    data: "test",
    success: loadMenu
  }) 
})
// 加载menu
function loadMenu(result) {
  // 遍历结果集
  $.each(result, function (index, value) {
    // 加载数据
    $(".sidebar-menu").append(sidebar_menu_add_li(value));
  });
  // console.log(JSON.stringify(result));
  $("a[data-url]").click(function (evt) {
    loadPage($(this).data("url"), $(this).data("id"), $(this).data("name"));
    $("ul.treeview-menu li").removeClass("active");
    $(this).parent().addClass("active");
  });
}

// 添加《li》
function sidebar_menu_add_li(item) {
  // 返回值
  var html = '';
  if (item.children.length == 0) {
    html = "<li><a href='#' data-url='" + item.url + "' data-id='" + item.id + "' data-name='" + item.name + "' ><i class='" + item.icon + "'></i>" + item.name + "</a></li>";
    if (item.homePage) {
      //loadPage(item.url);
    }
  } else {
    html = "<li class='treeview'>" + "<a href='#'>" + "<i class='" + item.icon + "'></i>" 
    + "<span>" + item.name + "</span>" + "<span class='pull-right-container'>"
      // + "<span class='label label-primary pull-right'>" + item.children.length + "</span>" 
      + "</span>" + "</a>" + "<ul class='treeview-menu'>";
    $.each(item.children, function (index, value) {
      html = html + sidebar_menu_add_li(value);
    });
    html = html + "</ul>" + "</li>";
  }
  return html;

}

function findError() {
};
function loadPage(url, id, name, paramter, flag_r) {
  $("#mainDiv").load(url, function (response, status, xhr) {
    if (status == "success") {
      if (response) {
        try {
          var result = jQuery.parseJSON(response);
          if (result.code == 100) {
            $("#mainDiv").html("");
            alert(result.data);
          }
        } catch (e) {
          return response;
        }
      }
    } else {
      $("#mainDiv").html("");
      return "/404.html";
    }
  });
}

/**
 * Load a url into a page
 */
var _old_load = jQuery.fn.load;
jQuery.fn.load = function (url, params, callback) {
  //update for HANZO, 2016/12/22
  if (typeof url !== "string" && _old_load) { return _old_load.apply(this, arguments); }

  var selector, type, response, self = this, off = url.indexOf(" ");
  if (off > -1) {
    selector = jQuery.trim(url.slice(off));
    url = url.slice(0, off);
  }
  if (jQuery.isFunction(params)) {
    callback = params;
    params = undefined;
  } else if (params && typeof params === "object") {
    type = "POST";
  }
  if (self.length > 0) {
    jQuery.ajax({
      url: url,
      beforeSend: function (xhr) {
        xhr.setRequestHeader('X-Requested-With', {
          toString: function () {
            return '';
          }
        });
      },
      type: type || "GET",
      dataType: "html",
      data: params
    }).done(function (responseText) {
      response = arguments;

      var reponseHtml = jQuery.parseHTML();
      //  			console.log($(responseText).find(selector).toArray());
      self.html(selector ? jQuery("<div>").append(jQuery.parseHTML(responseText)).find(selector) : responseText);
    }).always(callback && function (jqXHR, status) {
      self.each(function () {
        callback.apply(this, response || [jqXHR.responseText, status, jqXHR]);
      });
    });
  }

  return this;
};