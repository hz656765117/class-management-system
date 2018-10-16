/**
 * jquery底层方法扩充
 */
;(function($,win){
	//—————————————————————————————fn对象级的封装扩展————————————————————————————
	$.fn.extend({
		/**
		 * 判断某元素是否拥有指定的属性值，与原生js的hasAttribute相同；
		 * 如果是单一元素调用，则返回布尔类型参数，如果是元素集合调用，则返回由布尔类型组成的数组
		 * 方法包含两个参数，分别是属性名称/属性值
		 * 不指定属性值时，只要该元素包含属性，就返回true,指定属性值之后，需要确定属性值相同，才会返回true;
		 */
		isAttr:function(nodeName,nodeValue){
			if(nodeValue){
				if(this.length>1){
					var ary = [];
					this.each(function(index,value){
						ary.push(value.hasAttribute(nodeName) && value.getAttribute(nodeName)===nodeValue);
					});
					return ary;
				}else{
					return this.get(0).hasAttribute(nodeName) && this.attr(nodeName)===nodeValue;
				}
			}else{
				if(this.length>1){
					var ary = [];
					this.each(function(index,value){
						ary.push(value.hasAttribute(nodeName));
					});
					return ary;
				}else{
					return this.get(0).hasAttribute(nodeName);
				}
			}
		}
		/**
		 * 属性选择器的扩展，可以从一个集合中过滤得到包含指定属性的元素集合
		 */
		,hasAttr:function(nodeName){
			var ary = [];
			this.each(function(index,value){
				if(value.hasAttribute(nodeName)) ary.push(value);
			});
			return $(ary);
		}
		/**
		 * 多元属性选择器,只支持一个属性值的检查
		 */
		,containAttr:function(nodeName,nodeValue){
			var ary = [];
			this.each(function(index,value){
				if(value.hasAttribute(nodeName) && ($.inArray(nodeValue,value.getAttribute(nodeName).split(","))==-1?false:true)) 
					ary.push(value);
			});
			return $(ary);
		}
	});
	//————————————————————————————选择器级别的封装扩展————————————————————————————-
	$.extend($.expr[':'],{
	     //解析自己选择器，其中m是个数组，el是当前元素，m[3]便是选择器字符串，
	     // 如果返回true代表当前元素被选中，反之则否
		/**
		 * 属性选择器：根据当前元素是否包含指定属性进行过滤
		 */
		hasAttr:function(el, i, m){
	    	return el.hasAttribute(m[3]);
	    }
		/**
		 * 多元属性选择器：判断属性值（以逗号分隔）是否包含指定的属性值
		 */
		,containAttr:function(el,i,m){
			var ary = m[3].split(",");
			return el.hasAttribute(ary[0]) && ($.inArray(ary[1],el.getAttribute(ary[0]).split(","))==-1?false:true);
		}
		/**
		 * 选择所有宽度大于或小于指定值的元素：
		 */
	    ,width: function(el, i, m)
	    {
	        if(!m[3]||!(/^(<|>)\d+$/).test(m[3])) {return false;}
	        return m[3].substr(0,1) === '>' ? 
	            $(el).width() > m[3].substr(1) : $(el).width() < m[3].substr(1);
	    }
	    /**
	     * 选择所有高度大于或小于指定值的元素
	     */
	    ,height: function(el, i, m)
	    {
	        if(!m[3]||!(/^(<|>)\d+$/).test(m[3])) {return false;}
	        return m[3].substr(0,1) === '>' ? 
	            $(el).height() > m[3].substr(1) : $(el).height() < m[3].substr(1);
	    }
	    /**
	     * 选择在指定元素左边的所有元素
	     */
	    ,leftOf: function(el, i, m)
	    {
	        var oe = $(el).offset();
	        var om = $(m[3]).offset();
	        return oe.left + $(el).width() < om.left;
	    }
	    /**
	     * 选择在指定元素右边的所有元素
	     */
	    ,rightOf: function(el, i, m)
	    {
	        var oe = $(el).offset();
	        var om = $(m[3]).offset();
	        return oe.left > om.left + $(m[3]).width();
	    }
	    /**
	     * 选择所有带外站链接的锚点标签
	     */
	    ,external: function(el)
	    {
	        if(!el.href) {return false;}
	        return el.hostname && el.hostname !== window.location.hostname;
	    }
	    /**
	     * 选择指定target属性的锚点标签
	     */
	    ,target: function(el, i, m)
	    {
	        if(!m[3]) {return false;}
	        return (m[3] === '_self' && ($(el).attr('target') == '' || !el.target)) || 
	            (m[3] === $(el).attr('target'));
	    }
	    /**
	     * 选取位于可视窗口内的所有元素
	     */
	    ,inView: function(el)
	    {
	        var offset = $(el).offset();
	 
	        return !(
	            (offset.top > $(window).height() + $(document).scrollTop()) || 
	            (offset.top + $(el).height() < $(document).scrollTop()) || 
	            (offset.left > $(window).width() + $(document).scrollLeft()) || 
	            (offset.left + $(el).width() < $(document).scrollLeft())
	        );
	    }
	    /**
	     * 选择颜色为指定RGB值的所有元素
	     */
	    ,color: function(el, i, m)
	    {
	        if(!m[3]) {return false;}
	        return $(el).css('color') === m[3];
	    }
	    /**
	     * 选择存在id属性的所有元素
	     */
	    ,hasId: function(el)
	    {
	        return $(el).attr('id') !== undefined && $(el).attr('id') !== '';
	    }
	    /**
	     * 样式选择器，使用方式为：
	     * $("#form :css({color:'red'})")
	     */
	    ,css:function(el,i,m){
	        var s=eval("("+m[3]+")")
	        var r=/^[><=!]?=?/;
	        var t,cc
	        for(var c in s){
	            s[c]=s[c].replace(r,function(w){t=w;return ""})
	            if(t=="")t="==";
	                if(!m[9]){ 
	                  var d=$("#_csss");
	                  m[9]=d[0]&&d||$("<div id='_csss' style='display:none'>").appendTo("body") 
	                }
	                m[9].css(c,s[c]); 
	                cc=m[9].css(c);
	                if (eval("$(el).css(c)"+t+"cc"));
	                else return false;
	        }
	        return true;
	    }
	});
})(jQuery,window);