@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI4CF4B90
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.unicloud.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import io.dcloud.uniapp.extapi.`$emit` as uni__emit
import io.dcloud.uniapp.extapi.`$off` as uni__off
import io.dcloud.uniapp.extapi.`$on` as uni__on
import io.dcloud.uniapp.extapi.connectSocket as uni_connectSocket
import io.dcloud.uniapp.extapi.exit as uni_exit
import io.dcloud.uniapp.extapi.getSystemInfo as uni_getSystemInfo
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import io.dcloud.uniapp.extapi.onAppThemeChange as uni_onAppThemeChange
import io.dcloud.uniapp.extapi.openDialogPage as uni_openDialogPage
import io.dcloud.uniapp.extapi.rpx2px as uni_rpx2px
import io.dcloud.uniapp.extapi.showToast as uni_showToast
val runBlock1 = run {
    __uniConfig.getAppStyles = fun(): Map<String, Map<String, Map<String, Any>>> {
        return GenApp.styles
    }
}
fun initRuntimeSocket(hosts: String, port: String, id: String): UTSPromise<SocketTask?> {
    if (hosts == "" || port == "" || id == "") {
        return UTSPromise.resolve(null)
    }
    return hosts.split(",").reduce<UTSPromise<SocketTask?>>(fun(promise: UTSPromise<SocketTask?>, host: String): UTSPromise<SocketTask?> {
        return promise.then(fun(socket): UTSPromise<SocketTask?> {
            if (socket != null) {
                return UTSPromise.resolve(socket)
            }
            return tryConnectSocket(host, port, id)
        }
        )
    }
    , UTSPromise.resolve(null))
}
val SOCKET_TIMEOUT: Number = 500
fun tryConnectSocket(host: String, port: String, id: String): UTSPromise<SocketTask?> {
    return UTSPromise(fun(resolve, reject){
        val socket = uni_connectSocket(ConnectSocketOptions(url = "ws://" + host + ":" + port + "/" + id, fail = fun(_) {
            resolve(null)
        }
        ))
        val timer = setTimeout(fun(){
            socket.close(CloseSocketOptions(code = 1006, reason = "connect timeout"))
            resolve(null)
        }
        , SOCKET_TIMEOUT)
        socket.onOpen(fun(e){
            clearTimeout(timer)
            resolve(socket)
        }
        )
        socket.onClose(fun(e){
            clearTimeout(timer)
            resolve(null)
        }
        )
        socket.onError(fun(e){
            clearTimeout(timer)
            resolve(null)
        }
        )
    }
    )
}
fun initRuntimeSocketService(): UTSPromise<Boolean> {
    val hosts: String = "169.254.3.126,169.254.166.164,10.192.138.58,127.0.0.1"
    val port: String = "8090"
    val id: String = "app-android_RQCNNB"
    if (hosts == "" || port == "" || id == "") {
        return UTSPromise.resolve(false)
    }
    var socketTask: SocketTask? = null
    __registerWebViewUniConsole(fun(): String {
        return "!function(){\"use strict\";\"function\"==typeof SuppressedError&&SuppressedError;var e=[\"log\",\"warn\",\"error\",\"info\",\"debug\"],n=e.reduce((function(e,n){return e[n]=console[n].bind(console),e}),{}),t=null,r=new Set,o={};function i(e){if(null!=t){var n=e.map((function(e){if(\"string\"==typeof e)return e;var n=e&&\"promise\"in e&&\"reason\"in e,t=n?\"UnhandledPromiseRejection: \":\"\";if(n&&(e=e.reason),e instanceof Error&&e.stack)return e.message&&!e.stack.includes(e.message)?\"\".concat(t).concat(e.message,\"\\n\").concat(e.stack):\"\".concat(t).concat(e.stack);if(\"object\"==typeof e&&null!==e)try{return t+JSON.stringify(e)}catch(e){return t+String(e)}return t+String(e)})).filter(Boolean);n.length>0&&t(JSON.stringify(Object.assign({type:\"error\",data:n},o)))}else e.forEach((function(e){r.add(e)}))}function a(e,n){try{return{type:e,args:u(n)}}catch(e){}return{type:e,args:[]}}function u(e){return e.map((function(e){return c(e)}))}function c(e,n){if(void 0===n&&(n=0),n>=7)return{type:\"object\",value:\"[Maximum depth reached]\"};switch(typeof e){case\"string\":return{type:\"string\",value:e};case\"number\":return function(e){return{type:\"number\",value:String(e)}}(e);case\"boolean\":return function(e){return{type:\"boolean\",value:String(e)}}(e);case\"object\":try{return function(e,n){if(null===e)return{type:\"null\"};if(function(e){return e.\$&&s(e.\$)}(e))return function(e,n){return{type:\"object\",className:\"ComponentPublicInstance\",value:{properties:Object.entries(e.\$.type).map((function(e){return f(e[0],e[1],n+1)}))}}}(e,n);if(s(e))return function(e,n){return{type:\"object\",className:\"ComponentInternalInstance\",value:{properties:Object.entries(e.type).map((function(e){return f(e[0],e[1],n+1)}))}}}(e,n);if(function(e){return e.style&&null!=e.tagName&&null!=e.nodeName}(e))return function(e,n){return{type:\"object\",value:{properties:Object.entries(e).filter((function(e){var n=e[0];return[\"id\",\"tagName\",\"nodeName\",\"dataset\",\"offsetTop\",\"offsetLeft\",\"style\"].includes(n)})).map((function(e){return f(e[0],e[1],n+1)}))}}}(e,n);if(function(e){return\"function\"==typeof e.getPropertyValue&&\"function\"==typeof e.setProperty&&e.\$styles}(e))return function(e,n){return{type:\"object\",value:{properties:Object.entries(e.\$styles).map((function(e){return f(e[0],e[1],n+1)}))}}}(e,n);if(Array.isArray(e))return{type:\"object\",subType:\"array\",value:{properties:e.map((function(e,t){return function(e,n,t){var r=c(e,t);return r.name=\"\".concat(n),r}(e,t,n+1)}))}};if(e instanceof Set)return{type:\"object\",subType:\"set\",className:\"Set\",description:\"Set(\".concat(e.size,\")\"),value:{entries:Array.from(e).map((function(e){return function(e,n){return{value:c(e,n)}}(e,n+1)}))}};if(e instanceof Map)return{type:\"object\",subType:\"map\",className:\"Map\",description:\"Map(\".concat(e.size,\")\"),value:{entries:Array.from(e.entries()).map((function(e){return function(e,n){return{key:c(e[0],n),value:c(e[1],n)}}(e,n+1)}))}};if(e instanceof Promise)return{type:\"object\",subType:\"promise\",value:{properties:[]}};if(e instanceof RegExp)return{type:\"object\",subType:\"regexp\",value:String(e),className:\"Regexp\"};if(e instanceof Date)return{type:\"object\",subType:\"date\",value:String(e),className:\"Date\"};if(e instanceof Error)return{type:\"object\",subType:\"error\",value:e.message||String(e),className:e.name||\"Error\"};var t=void 0,r=e.constructor;r&&r.get\$UTSMetadata\$&&(t=r.get\$UTSMetadata\$().name);var o=Object.entries(e);(function(e){return e.modifier&&e.modifier._attribute&&e.nodeContent})(e)&&(o=o.filter((function(e){var n=e[0];return\"modifier\"!==n&&\"nodeContent\"!==n})));return{type:\"object\",className:t,value:{properties:o.map((function(e){return f(e[0],e[1],n+1)}))}}}(e,n)}catch(e){return{type:\"object\",value:{properties:[]}}}case\"undefined\":return{type:\"undefined\"};case\"function\":return function(e){return{type:\"function\",value:\"function \".concat(e.name,\"() {}\")}}(e);case\"symbol\":return function(e){return{type:\"symbol\",value:e.description}}(e);case\"bigint\":return function(e){return{type:\"bigint\",value:String(e)}}(e)}}function s(e){return e.type&&null!=e.uid&&e.appContext}function f(e,n,t){var r=c(n,t);return r.name=e,r}var l=null,p=[],y={},g=\"---BEGIN:EXCEPTION---\",d=\"---END:EXCEPTION---\";function v(e){null!=l?l(JSON.stringify(Object.assign({type:\"console\",data:e},y))):p.push.apply(p,e)}var m=/^\\s*at\\s+[\\w/./-]+:\\d+\$/;function b(){function t(e){return function(){for(var t=[],r=0;r<arguments.length;r++)t[r]=arguments[r];var o=function(e,n,t){if(t||2===arguments.length)for(var r,o=0,i=n.length;o<i;o++)!r&&o in n||(r||(r=Array.prototype.slice.call(n,0,o)),r[o]=n[o]);return e.concat(r||Array.prototype.slice.call(n))}([],t,!0);if(o.length){var u=o[o.length-1];\"string\"==typeof u&&m.test(u)&&o.pop()}if(n[e].apply(n,o),\"error\"===e&&1===t.length){var c=t[0];if(\"string\"==typeof c&&c.startsWith(g)){var s=g.length,f=c.length-d.length;return void i([c.slice(s,f)])}if(c instanceof Error)return void i([c])}v([a(e,t)])}}return function(){var e=console.log,n=Symbol();try{console.log=n}catch(e){return!1}var t=console.log===n;return console.log=e,t}()?(e.forEach((function(e){console[e]=t(e)})),function(){e.forEach((function(e){console[e]=n[e]}))}):function(){}}function _(e){var n={type:\"WEB_INVOKE_APPSERVICE\",args:{data:{name:\"console\",arg:e}}};return window.__uniapp_x_postMessageToService?window.__uniapp_x_postMessageToService(n):window.__uniapp_x_.postMessageToService(JSON.stringify(n))}!function(){if(!window.__UNI_CONSOLE_WEBVIEW__){window.__UNI_CONSOLE_WEBVIEW__=!0;var e=\"[web-view]\".concat(window.__UNI_PAGE_ROUTE__?\"[\".concat(window.__UNI_PAGE_ROUTE__,\"]\"):\"\");b(),function(e,n){if(void 0===n&&(n={}),l=e,Object.assign(y,n),null!=e&&p.length>0){var t=p.slice();p.length=0,v(t)}}((function(e){_(e)}),{channel:e}),function(e,n){if(void 0===n&&(n={}),t=e,Object.assign(o,n),null!=e&&r.size>0){var a=Array.from(r);r.clear(),i(a)}}((function(e){_(e)}),{channel:e}),window.addEventListener(\"error\",(function(e){i([e.error])})),window.addEventListener(\"unhandledrejection\",(function(e){i([e])}))}}()}();"
    }
    , fun(data: String){
        socketTask?.send(SendSocketMessageOptions(data = data))
    }
    )
    return UTSPromise.resolve().then(fun(): UTSPromise<Boolean> {
        return initRuntimeSocket(hosts, port, id).then(fun(socket): Boolean {
            if (socket == null) {
                return false
            }
            socketTask = socket
            return true
        }
        )
    }
    ).`catch`(fun(): Boolean {
        return false
    }
    )
}
val runBlock2 = run {
    initRuntimeSocketService()
}
open class Config (
    @JsonNotNull
    open var theme: String,
    @JsonNotNull
    open var unit: String,
) : UTSReactiveObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("Config", "uni_modules/rice-ui/libs/store/useConfigStore.uts", 1, 13)
    }
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return ConfigReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class ConfigReactiveObject : Config, IUTSReactive<Config> {
    override var __v_raw: Config
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: Config, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(theme = __v_raw.theme, unit = __v_raw.unit) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): ConfigReactiveObject {
        return ConfigReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var theme: String
        get() {
            return _tRG(__v_raw, "theme", __v_raw.theme, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("theme")) {
                return
            }
            val oldValue = __v_raw.theme
            __v_raw.theme = value
            _tRS(__v_raw, "theme", oldValue, value)
        }
    override var unit: String
        get() {
            return _tRG(__v_raw, "unit", __v_raw.unit, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("unit")) {
                return
            }
            val oldValue = __v_raw.unit
            __v_raw.unit = value
            _tRS(__v_raw, "unit", oldValue, value)
        }
}
val config = reactive<Config>(Config(theme = "light", unit = "px"))
val isDark = computed(fun(): Boolean {
    return config.theme == "dark"
}
)
val setTheme = fun(theme: String){
    config.theme = theme
}
fun useCssVar(prop: String, target: Ref<UniElement?>): Ref<String> {
    val variable = ref("")
    val updateCssVar = fun(){
        if (target.value != null && prop != "") {
            variable.value = target.value!!.style.getPropertyValue(prop)
        }
    }
    watch(_uA(
        target,
        isDark
    ), fun(): UTSPromise<Unit> {
        return wrapUTSPromise(suspend {
                await(nextTick())
                if (target.value != null) {
                    updateCssVar()
                }
        })
    }
    , WatchOptions(immediate = true))
    return variable
}
fun debugWarn(scope: String, mess: String) {
    if ("development" != "production") {
        val err = "[RiceUI] " + scope + ":" + mess
        console.warn(err, " at uni_modules/rice-ui/libs/utils/debug.uts:4")
    }
}
open class SplitCssPropertyResult (
    @JsonNotNull
    open var textCssProperty: UTSJSONObject,
    @JsonNotNull
    open var rectCssProperty: UTSJSONObject,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("SplitCssPropertyResult", "uni_modules/rice-ui/libs/utils/format.uts", 2, 6)
    }
}
val addUnit = fun(value: Any): String {
    val isNumeric = UTSAndroid.`typeof`(value) == "number" || UTSRegExp("^\\d+(\\.\\d+)?\$", "").test(value as String)
    return if (isNumeric) {
        "" + value + config.unit
    } else {
        (value as String).toString()
    }
}
val splitCssProperty = fun(css: UTSJSONObject?): SplitCssPropertyResult {
    val textCssProperty: UTSJSONObject = object : UTSJSONObject(UTSSourceMapPosition("textCssProperty", "uni_modules/rice-ui/libs/utils/format.uts", 18, 11)) {
    }
    val rectCssProperty: UTSJSONObject = object : UTSJSONObject(UTSSourceMapPosition("rectCssProperty", "uni_modules/rice-ui/libs/utils/format.uts", 19, 11)) {
    }
    if (css != null) {
        val textProperties = _uA(
            "color",
            "font-family",
            "fontFamily",
            "font-size",
            "fontSize",
            "font-weight",
            "fontWeight",
            "font-style",
            "fontStyle",
            "text-align",
            "textAlign",
            "text-decoration",
            "textDecoration",
            "line-height",
            "lineHeight",
            "letter-spacing",
            "letterSpacing",
            "text-overflow",
            "textOverflow",
            "white-space",
            "whiteSpace",
            "lines"
        )
        for(key in resolveUTSKeyIterator(css)){
            if (textProperties.includes(key)) {
                textCssProperty[key] = css[key]
            } else {
                rectCssProperty[key] = css[key]
            }
        }
    }
    return SplitCssPropertyResult(textCssProperty = textCssProperty, rectCssProperty = rectCssProperty)
}
typealias BeforeChangeInterceptor = () -> Any
fun getRandomStr(length: Number = 10): String {
    val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    var result = ""
    run {
        var i: Number = 0
        while(i < length){
            val randomIndex = Math.floor(Math.random() * characters.length)
            result += characters.charAt(randomIndex)
            i++
        }
    }
    return result
}
val hasStrValue = fun(reassignedStr: Any?): Boolean {
    var str = reassignedStr
    if (str == null) {
        return false
    }
    if (UTSAndroid.`typeof`(str) != "string") {
        str = (str as Number).toString()
    }
    return (str as String).trim().length > 0
}
fun getPxNum(reassignedValue: Any, totalWidth: Number = 0): Number {
    var value = reassignedValue
    if (UTSAndroid.`typeof`(value) == "number") {
        if (config.unit != "rpx") {
            return value as Number
        }
        value = (value as Number) + "rpx"
    }
    if ((value as String).endsWith("rpx")) {
        return uni_rpx2px(parseFloat(value as String))
    }
    if ((value as String).endsWith("%")) {
        return parseFloat(value as String) * 0.01 * totalWidth
    }
    return parseFloat(value as String)
}
val isGradientColor = fun(color: String?): Boolean {
    if (color == null || color == "") {
        return false
    }
    val gradientRegex = UTSRegExp("(linear-gradient|radial-gradient|conic-gradient)\\(", "i")
    return gradientRegex.test(color!!)
}
val isThemeColor = fun(type: String?): Boolean {
    if (type == null || type == "") {
        return false
    }
    return _uA(
        "primary",
        "success",
        "warning",
        "error"
    ).includes(type)
}
val isPromise = fun(kVal: Any): Boolean {
    return UTSAndroid.`typeof`(kVal) == "object" && kVal is UTSPromise<*>
}
open class InterceptorOption (
    open var done: () -> Unit,
    open var args: UTSArray<Any>? = null,
    open var canceled: (() -> Unit)? = null,
    open var error: (() -> Unit)? = null,
    open var undone: (() -> Unit)? = null,
    open var complete: (() -> Unit)? = null,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("InterceptorOption", "uni_modules/rice-ui/libs/utils/tools.uts", 110, 13)
    }
}
fun callInterceptor(interceptor: BeforeChangeInterceptor, interceptorOption: InterceptorOption) {
    val done = interceptorOption.done
    val canceled = interceptorOption.canceled
    val error = interceptorOption.error
    val undone = interceptorOption.undone
    val complete = interceptorOption.complete
    val returnVal = interceptor!!()
    if (isPromise(returnVal)) {
        val promiseVal = returnVal as UTSPromise<Boolean>
        promiseVal.then(fun(result: Boolean){
            if (result == true) {
                done()
                if (complete != null) {
                    complete!!()
                }
            } else {
                if (canceled != null) {
                    canceled!!()
                }
                if (undone != null) {
                    undone!!()
                }
                if (complete != null) {
                    complete!!()
                }
            }
        }).`catch`(fun(){
            if (error != null) {
                error!!()
            }
            if (undone != null) {
                undone!!()
            }
            if (complete != null) {
                complete!!()
            }
        })
    } else {
        if (returnVal == true) {
            done()
        } else if (canceled != null) {
            canceled()
            if (undone != null) {
                undone!!()
            }
        }
        if (complete != null) {
            complete!!()
        }
    }
}
val getUID = fun(): String {
    return Date.now() + "" + Math.floor(Math.random() * 1e7)
}
open class UseNamespace (
    open var b: (blockSuffix: String) -> String,
    open var e: (element: String?) -> String,
    open var m: (modifier: String?) -> String,
    open var `is`: (name: String, state: Boolean?) -> String,
    open var theme: () -> String,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("UseNamespace", "uni_modules/rice-ui/libs/use/useNamespace/index.uts", 3, 13)
    }
}
val createBem = fun(block: String, blockSuffix: String, element: String, modifier: String): String {
    var cls = block
    if (blockSuffix != "") {
        cls += "-" + blockSuffix
    }
    if (element != "") {
        cls += "__" + element
    }
    if (modifier != "") {
        cls += "--" + modifier
    }
    return cls
}
fun useNamespace(block: String): UseNamespace {
    val prefix = "rice-" + block
    val b = fun(blockSuffix: String): String {
        return createBem(prefix, blockSuffix, "", "")
    }
    val e = fun(element: String?): String {
        return if (hasStrValue(element)) {
            createBem(prefix, "", element!!, "")
        } else {
            ""
        }
    }
    val m = fun(modifier: String?): String {
        return if (hasStrValue(modifier)) {
            createBem(prefix, "", "", modifier!!)
        } else {
            ""
        }
    }
    val kIs = fun(name: String, state: Boolean?): String {
        val symbol = if ((name.startsWith("-") || name.startsWith("_"))) {
            ""
        } else {
            "--"
        }
        return if (state == true) {
            prefix + symbol + name
        } else {
            ""
        }
    }
    val theme = fun(): String {
        return if (isDark.value) {
            "rice-theme-dark rice-variables"
        } else {
            "rice-theme-light rice-variables"
        }
    }
    return UseNamespace(b = b, e = e, m = m, `is` = kIs, theme = theme)
}
open class UseSafeArea (
    @JsonNotNull
    open var safeBottom: Ref<Number>,
    @JsonNotNull
    open var safeTop: Ref<Number>,
    @JsonNotNull
    open var statusBarHeight: Ref<Number>,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("UseSafeArea", "uni_modules/rice-ui/libs/use/useSafeArea/index.uts", 2, 13)
    }
}
fun useSafeArea(): UseSafeArea {
    val safeBottom = ref(0)
    val safeTop = ref(0)
    val statusBarHeight = ref(0)
    val getWindowInfo = fun(): UTSPromise<Unit> {
        return wrapUTSPromise(suspend {
                await(nextTick())
                val windowInfo = uni_getWindowInfo()
                val areaInfo = windowInfo.safeArea
                if (areaInfo.bottom > 0) {
                    safeBottom.value = windowInfo.screenHeight - areaInfo.bottom
                }
                if (areaInfo.top > 0) {
                    safeTop.value = areaInfo.top
                }
                statusBarHeight.value = windowInfo.statusBarHeight
        })
    }
    var timer: Number? = null
    onMounted(fun(){
        if (timer != null) {
            clearTimeout(timer!!)
        }
        timer = setTimeout(fun(){
            getWindowInfo()
        }
        , 200)
    }
    )
    onUnmounted(fun(){
        if (timer != null) {
            clearTimeout(timer!!)
        }
    }
    )
    return UseSafeArea(safeTop = safeTop, safeBottom = safeBottom, statusBarHeight = statusBarHeight)
}
val MIN_DISTANCE: Number = 10
val LOCK_DIRECTION_DISTANCE: Number = 10
val TAP_OFFSET: Number = 5
typealias SlideDirection = String
open class UseTouch (
    @JsonNotNull
    open var startX: Ref<Number>,
    @JsonNotNull
    open var startY: Ref<Number>,
    @JsonNotNull
    open var deltaX: Ref<Number>,
    @JsonNotNull
    open var deltaY: Ref<Number>,
    @JsonNotNull
    open var offsetX: Ref<Number>,
    @JsonNotNull
    open var offsetY: Ref<Number>,
    @JsonNotNull
    open var direction: Ref<SlideDirection>,
    @JsonNotNull
    open var isTap: Ref<Boolean>,
    @JsonNotNull
    open var skipMove: Ref<Boolean>,
    @JsonNotNull
    open var dragging: Ref<Boolean>,
    open var start: (e: UniTouchEvent) -> Unit,
    open var move: (e: UniTouchEvent) -> Unit,
    open var end: () -> Unit,
    open var changeDragging: (flag: Boolean) -> Unit,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("UseTouch", "uni_modules/rice-ui/libs/use/useTouch/index.uts", 6, 6)
    }
}
fun getSlideDirection(x: Number, y: Number): SlideDirection {
    if (x > y && x > MIN_DISTANCE) {
        return "horizontal"
    }
    if (y > x && y > MIN_DISTANCE) {
        return "vertical"
    }
    return ""
}
fun useTouch(): UseTouch {
    val startX = ref(0)
    val startY = ref(0)
    val deltaX = ref(0)
    val deltaY = ref(0)
    val offsetX = ref(0)
    val offsetY = ref(0)
    val direction = ref<SlideDirection>("")
    val isTap = ref(false)
    val dragging = ref(false)
    val skipMove = ref(false)
    val reset = fun(){
        deltaX.value = 0
        deltaY.value = 0
        offsetX.value = 0
        offsetY.value = 0
        direction.value = ""
        isTap.value = true
        dragging.value = true
        skipMove.value = false
    }
    val start = fun(e: UniTouchEvent){
        val touches = e.touches[0]
        reset()
        startX.value = touches.clientX
        startY.value = touches.clientY
    }
    val move = fun(e: UniTouchEvent){
        val touches = e.touches[0]
        deltaX.value = touches.clientX - startX.value
        deltaY.value = touches.clientY - startY.value
        offsetX.value = Math.abs(deltaX.value)
        offsetY.value = Math.abs(deltaY.value)
        if (direction.value == "" || (offsetX.value < LOCK_DIRECTION_DISTANCE && offsetY.value < LOCK_DIRECTION_DISTANCE)) {
            direction.value = getSlideDirection(offsetX.value, offsetY.value)
        }
        if (isTap.value && (offsetX.value > TAP_OFFSET || offsetY.value > TAP_OFFSET)) {
            isTap.value = false
        }
        if (direction.value == "vertical") {
            skipMove.value = true
        }
    }
    val end = fun(){
        dragging.value = false
    }
    val changeDragging = fun(flag: Boolean){
        dragging.value = flag
    }
    return UseTouch(startX = startX, startY = startY, deltaX = deltaX, deltaY = deltaY, offsetX = offsetX, offsetY = offsetY, direction = direction, isTap = isTap, dragging = dragging, skipMove = skipMove, start = start, move = move, end = end, changeDragging = changeDragging)
}
val presetColors: UTSJSONObject = object : UTSJSONObject(UTSSourceMapPosition("presetColors", "uni_modules/rice-ui/libs/plugin/coloruts/constant.uts", 44, 14)) {
    var aliceblue = "9ehhb"
    var antiquewhite = "9sgk7"
    var aqua = "1ekf"
    var aquamarine = "4zsno"
    var azure = "9eiv3"
    var beige = "9lhp8"
    var bisque = "9zg04"
    var black = "0"
    var blanchedalmond = "9zhe5"
    var blue = "73"
    var blueviolet = "5e31e"
    var brown = "6g016"
    var burlywood = "8ouiv"
    var cadetblue = "3qba8"
    var chartreuse = "4zshs"
    var chocolate = "87k0u"
    var coral = "9yvyo"
    var cornflowerblue = "3xael"
    var cornsilk = "9zjz0"
    var crimson = "8l4xo"
    var cyan = "1ekf"
    var darkblue = "3v"
    var darkcyan = "rkb"
    var darkgoldenrod = "776yz"
    var darkgray = "6mbhl"
    var darkgreen = "jr4"
    var darkgrey = "6mbhl"
    var darkkhaki = "7ehkb"
    var darkmagenta = "5f91n"
    var darkolivegreen = "3bzfz"
    var darkorange = "9yygw"
    var darkorchid = "5z6x8"
    var darkred = "5f8xs"
    var darksalmon = "9441m"
    var darkseagreen = "5lwgf"
    var darkslateblue = "2th1n"
    var darkslategray = "1ugcv"
    var darkslategrey = "1ugcv"
    var darkturquoise = "14up"
    var darkviolet = "5rw7n"
    var deeppink = "9yavn"
    var deepskyblue = "11xb"
    var dimgray = "442g9"
    var dimgrey = "442g9"
    var dodgerblue = "16xof"
    var firebrick = "6y7tu"
    var floralwhite = "9zkds"
    var forestgreen = "1cisi"
    var fuchsia = "9y70f"
    var gainsboro = "8m8kc"
    var ghostwhite = "9pq0v"
    var goldenrod = "8j4f4"
    var gold = "9zda8"
    var gray = "50i2o"
    var green = "pa8"
    var greenyellow = "6senj"
    var grey = "50i2o"
    var honeydew = "9eiuo"
    var hotpink = "9yrp0"
    var indianred = "80gnw"
    var indigo = "2xcoy"
    var ivory = "9zldc"
    var khaki = "9edu4"
    var lavenderblush = "9ziet"
    var lavender = "90c8q"
    var lawngreen = "4vk74"
    var lemonchiffon = "9zkct"
    var lightblue = "6s73a"
    var lightcoral = "9dtog"
    var lightcyan = "8s1rz"
    var lightgoldenrodyellow = "9sjiq"
    var lightgray = "89jo3"
    var lightgreen = "5nkwg"
    var lightgrey = "89jo3"
    var lightpink = "9z6wx"
    var lightsalmon = "9z2ii"
    var lightseagreen = "19xgq"
    var lightskyblue = "5arju"
    var lightslategray = "4nwk9"
    var lightslategrey = "4nwk9"
    var lightsteelblue = "6wau6"
    var lightyellow = "9zlcw"
    var lime = "1edc"
    var limegreen = "1zcxe"
    var linen = "9shk6"
    var magenta = "9y70f"
    var maroon = "4zsow"
    var mediumaquamarine = "40eju"
    var mediumblue = "5p"
    var mediumorchid = "79qkz"
    var mediumpurple = "5r3rv"
    var mediumseagreen = "2d9ip"
    var mediumslateblue = "4tcku"
    var mediumspringgreen = "1di2"
    var mediumturquoise = "2uabw"
    var mediumvioletred = "7rn9h"
    var midnightblue = "z980"
    var mintcream = "9ljp6"
    var mistyrose = "9zg0x"
    var moccasin = "9zfzp"
    var navajowhite = "9zest"
    var navy = "3k"
    var oldlace = "9wq92"
    var olive = "50hz4"
    var olivedrab = "472ub"
    var orange = "9z3eo"
    var orangered = "9ykg0"
    var orchid = "8iu3a"
    var palegoldenrod = "9bl4a"
    var palegreen = "5yw0o"
    var paleturquoise = "6v4ku"
    var palevioletred = "8k8lv"
    var papayawhip = "9zi6t"
    var peachpuff = "9ze0p"
    var peru = "80oqn"
    var pink = "9z8wb"
    var plum = "8nba5"
    var powderblue = "6wgdi"
    var purple = "4zssg"
    var rebeccapurple = "3zk49"
    var red = "9y6tc"
    var rosybrown = "7cv4f"
    var royalblue = "2jvtt"
    var saddlebrown = "5fmkz"
    var salmon = "9rvci"
    var sandybrown = "9jn1c"
    var seagreen = "1tdnb"
    var seashell = "9zje6"
    var sienna = "6973h"
    var silver = "7ir40"
    var skyblue = "5arjf"
    var slateblue = "45e4t"
    var slategray = "4e100"
    var slategrey = "4e100"
    var snow = "9zke2"
    var springgreen = "1egv"
    var steelblue = "2r1kk"
    var tan = "87yx8"
    var teal = "pds"
    var thistle = "8ggk8"
    var tomato = "9yqfb"
    var turquoise = "2j4r4"
    var violet = "9b10u"
    var wheat = "9ld4j"
    var white = "9zldr"
    var whitesmoke = "9lhpx"
    var yellow = "9zl6o"
    var yellowgreen = "61fzm"
}
fun fillArr(arr: UTSArray<String>): UTSArray<String> {
    while(arr.length < 4){
        arr.push("")
    }
    return arr
}
fun splitColorStr(str: String, parseNum: ParseNumber): UTSArray<Number> {
    val match = str.replace(UTSRegExp("^[^(]*\\((.*)", ""), "\$1").replace(UTSRegExp("\\).*", ""), "").match(UTSRegExp("\\d*\\.?\\d+%?", "g")) ?: _uA<String>()
    val m = fillArr(match as UTSArray<String>) as UTSArray<String>
    var numList = m.map(fun(item: String): Number {
        return parseFloat(item as String)
    }
    )
    run {
        var i: Number = 0
        while(i < 3){
            numList[i] = parseNum(numList[i], m[i], i)
            i += 1
        }
    }
    if (m[3] != "") {
        numList[3] = if (m[3].includes("%")) {
            numList[3] / 100
        } else {
            numList[3]
        }
    } else {
        numList[3] = 1
    }
    return numList
}
fun limitRange(value: Number, max: Number = 255): Number {
    val mergedMax = if (max == 0) {
        255
    } else {
        max
    }
    if (value > mergedMax) {
        return mergedMax
    }
    if (value < 0) {
        return 0
    }
    return value
}
val parseHSVorHSL: ParseNumber = fun(num: Number, _: String, index: Number): Number {
    return if (index == 0) {
        num
    } else {
        num / 100
    }
}
open class Coloruts : IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("Coloruts", "uni_modules/rice-ui/libs/plugin/coloruts/conversion.uts", 4, 14)
    }
    open var isValid: Boolean = true
    open var r: Number = 0
    open var g: Number = 0
    open var b: Number = 0
    open var a: Number = 1
    private var _h: Number? = null
    private var _s: Number? = null
    private var _l: Number? = null
    private var _v: Number? = null
    private var _max: Number? = null
    private var _min: Number? = null
    private var _brightness: Number? = null
    constructor(input: Any){
        fun isRgb(): Boolean {
            val inp = input as UTSJSONObject
            return inp["r"] != null && inp["g"] != null && inp["b"] != null
        }
        fun isHsl(): Boolean {
            val inp = input as UTSJSONObject
            return inp["h"] != null && inp["s"] != null && inp["l"] != null
        }
        fun isHsv(): Boolean {
            val inp = input as UTSJSONObject
            return inp["h"] != null && inp["s"] != null && inp["v"] != null
        }
        if (UTSAndroid.`typeof`(input) == "string") {
            val trimStr = (input as String).trim()
            fun matchPrefix(prefix: String): Boolean {
                return trimStr.startsWith(prefix)
            }
            if (UTSRegExp("^#?[A-F\\d]{3,8}\$", "i").test(trimStr)) {
                this.fromHexString(trimStr)
            } else if (matchPrefix("rgb")) {
                this.fromRgbString(trimStr)
            } else if (matchPrefix("hsl")) {
                this.fromHslString(trimStr)
            } else if (matchPrefix("hsv") || matchPrefix("hsb")) {
                this.fromHsvString(trimStr)
            } else {
                val presetColor = presetColors[trimStr.toLowerCase()] as String?
                if (presetColor != null) {
                    this.fromHexString(parseInt(presetColor, 36).toString(16).padStart(6, "0"))
                }
            }
        } else if (input is Coloruts) {
            this.r = (input as Coloruts).r
            this.g = (input as Coloruts).g
            this.b = (input as Coloruts).b
            this.a = (input as Coloruts).a
            this._h = (input as Coloruts)._h
            this._s = (input as Coloruts)._s
            this._l = (input as Coloruts)._l
            this._v = (input as Coloruts)._v
        } else if (isRgb()) {
            val data = input as UTSJSONObject
            this.r = limitRange(data["r"] as Number)
            this.g = limitRange(data["g"] as Number)
            this.b = limitRange(data["b"] as Number)
            this.a = if (UTSAndroid.`typeof`(data["a"]) == "number") {
                limitRange(data["a"] as Number, 1)
            } else {
                1
            }
        } else if (isHsl()) {
            this.fromHsl(input as UTSJSONObject)
        } else if (isHsv()) {
            this.fromHsv(input as UTSJSONObject)
        } else {
            console.warn("不支持当前的颜色值。" + input as UTSJSONObject, " at uni_modules/rice-ui/libs/plugin/coloruts/conversion.uts:78")
        }
    }
    private fun fromHexString(trimStr: String) {
        val withoutPrefix = trimStr.replace("#", "") as String
        fun connectNum(index1: Number, reassignedIndex2: Number?): Number {
            var index2 = reassignedIndex2
            if (index2 == null || index2 == 0) {
                index2 = index1
            }
            val str = "" + withoutPrefix[index1] + withoutPrefix[index2]
            return parseInt(str, 16)
        }
        if (withoutPrefix.length < 6) {
            this.r = connectNum(0, null)
            this.g = connectNum(1, null)
            this.b = connectNum(2, null)
            this.a = if (withoutPrefix.length >= 4) {
                connectNum(3, null) / 255
            } else {
                1
            }
        } else {
            this.r = connectNum(0, 1)
            this.g = connectNum(2, 3)
            this.b = connectNum(4, 5)
            this.a = if (withoutPrefix.length >= 7) {
                connectNum(6, 7) / 255
            } else {
                1
            }
        }
    }
    private fun fromHsv(hsva: UTSJSONObject) {
        val h = hsva["h"] as Number
        val s = hsva["s"] as Number
        val v = hsva["v"] as Number
        val a = hsva["a"] as Number?
        this._h = h % 360
        this._s = s
        this._v = v
        this.a = if (UTSAndroid.`typeof`(a) == "number") {
            a
        } else {
            1
        }
         as Number
        val vv = Math.round(v * 255)
        this.r = vv
        this.g = vv
        this.b = vv
        if (s <= 0) {
            return
        }
        val hh = h / 60
        val i = Math.floor(hh)
        val ff = hh - i
        val p = Math.round(v * (1.0 - s) * 255)
        val q = Math.round(v * (1.0 - s * ff) * 255)
        val t = Math.round(v * (1.0 - s * (1.0 - ff)) * 255)
        when (i) {
            0 -> 
                {
                    this.g = t
                    this.b = p
                }
            1 -> 
                {
                    this.r = q
                    this.b = p
                }
            2 -> 
                {
                    this.r = p
                    this.b = t
                }
            3 -> 
                {
                    this.r = p
                    this.g = q
                }
            4 -> 
                {
                    this.r = t
                    this.g = p
                }
            5 -> 
                {
                    this.g = p
                    this.b = q
                }
            else -> 
                {
                    this.g = p
                    this.b = q
                }
        }
    }
    private fun fromHsl(hsla: UTSJSONObject) {
        val h = hsla["h"] as Number
        val s = hsla["s"] as Number
        val l = hsla["l"] as Number
        val a = hsla["a"] as Number?
        this._h = h % 360
        this._s = s
        this._l = l
        this.a = if (UTSAndroid.`typeof`(a) == "number") {
            a
        } else {
            1
        }
         as Number
        if (s <= 0) {
            val rgb = Math.round(l * 255)
            this.r = rgb
            this.g = rgb
            this.b = rgb
        }
        var r: Number = 0
        var g: Number = 0
        var b: Number = 0
        val huePrime = h / 60
        val chroma = (1 - Math.abs(2 * l - 1)) * s
        val secondComponent = chroma * (1 - Math.abs(huePrime % 2 - 1))
        if (huePrime >= 0 && huePrime < 1) {
            r = chroma
            g = secondComponent
        } else if (huePrime >= 1 && huePrime < 2) {
            r = secondComponent
            g = chroma
        } else if (huePrime >= 2 && huePrime < 3) {
            g = chroma
            b = secondComponent
        } else if (huePrime >= 3 && huePrime < 4) {
            g = secondComponent
            b = chroma
        } else if (huePrime >= 4 && huePrime < 5) {
            r = secondComponent
            b = chroma
        } else if (huePrime >= 5 && huePrime < 6) {
            r = chroma
            b = secondComponent
        }
        val lightnessModification = l - chroma / 2
        this.r = Math.round((r + lightnessModification) * 255)
        this.g = Math.round((g + lightnessModification) * 255)
        this.b = Math.round((b + lightnessModification) * 255)
    }
    private fun fromHslString(trimStr: String) {
        val cells = splitColorStr(trimStr, parseHSVorHSL)
        this.fromHsl(object : UTSJSONObject() {
            var h = cells[0]
            var s = cells[1]
            var l = cells[2]
            var a = cells[3]
        })
    }
    private fun fromHsvString(trimStr: String) {
        val cells = splitColorStr(trimStr, parseHSVorHSL)
        this.fromHsv(object : UTSJSONObject() {
            var h = cells[0]
            var s = cells[1]
            var v = cells[2]
            var a = cells[3]
        })
    }
    private fun fromRgbString(trimStr: String) {
        val cells = splitColorStr(trimStr, fun(num, txt, _index): Number {
            return if (txt.includes("%")) {
                Math.round((num / 100) * 255)
            } else {
                num
            }
        }
        )
        this.r = cells[0]
        this.g = cells[1]
        this.b = cells[2]
        this.a = cells[3]
    }
    open fun _c(input: Any): Coloruts {
        return Coloruts(input)
    }
    private fun getMax(): Number {
        if (this._max == null) {
            this._max = Math.max(this.r, this.g, this.b)
        }
        return this._max!!
    }
    private fun getMin(): Number {
        if (this._min == null) {
            this._min = Math.min(this.r, this.g, this.b)
        }
        return this._min!!
    }
    private fun getHue(): Number {
        if (this._h == null) {
            val delta = this.getMax() - this.getMin()
            if (delta == 0) {
                this._h = 0
            } else {
                this._h = Math.round(60 * (if (this.r === this.getMax()) {
                    (this.g - this.b) / delta + (if (this.g < this.b) {
                        6
                    } else {
                        0
                    })
                } else {
                    if (this.g === this.getMax()) {
                        (this.b - this.r) / delta + 2
                    } else {
                        (this.r - this.g) / delta + 4
                    }
                }
                ))
            }
        }
        return this._h!!
    }
    private fun getSaturation(): Number {
        if (this._s == null) {
            val delta = this.getMax() - this.getMin()
            if (delta == 0) {
                this._s = 0
            } else {
                this._s = delta / this.getMax()
            }
        }
        return this._s!!
    }
    private fun getValue(): Number {
        if (this._v == null) {
            this._v = this.getMax() / 255
        }
        return this._v!!
    }
    private fun getLightness(): Number {
        if (this._l == null) {
            this._l = (this.getMax() + this.getMin()) / 510
        }
        return this._l!!
    }
    private fun getBrightness(): Number {
        if (this._brightness == null) {
            this._brightness = (this.r * 299 + this.g * 587 + this.b * 114) / 1000
        }
        return this._brightness!!
    }
    open fun toHsv(): UTSJSONObject {
        return _uO("h" to this.getHue(), "s" to this.getSaturation(), "v" to this.getValue(), "a" to this.a)
    }
    open fun toRgb(): UTSJSONObject {
        return _uO("r" to this.r, "g" to this.g, "b" to this.b, "a" to this.a)
    }
    open fun toRgbString(): String {
        return if (this.a != 1) {
            "rgba(" + this.r + "," + this.g + "," + this.b + "," + this.a + ")"
        } else {
            "rgb(" + this.r + "," + this.g + "," + this.b + ")"
        }
    }
    open fun toHexString(): String {
        var hex = "#"
        val rHex = this.r.toString(16)
        hex += if (rHex.length == 2) {
            rHex
        } else {
            "0" + rHex
        }
        val gHex = this.g.toString(16)
        hex += if (gHex.length == 2) {
            gHex
        } else {
            "0" + gHex
        }
        val bHex = this.b.toString(16)
        hex += if (bHex.length == 2) {
            bHex
        } else {
            "0" + bHex
        }
        if (UTSAndroid.`typeof`(this.a) == "number" && this.a >= 0 && this.a < 1) {
            val aHex = Math.round(this.a * 255).toString(16)
            hex += if (aHex.length == 2) {
                aHex
            } else {
                "0" + aHex
            }
        }
        return hex
    }
    open fun mix(input: Any, amount: Number = 50): Coloruts {
        val color = this._c(input)
        val p = amount / 100
        val calc = fun(key: String): Number {
            if (key == "r") {
                return (color.r - this.r) * p + this.r
            }
            if (key == "g") {
                return (color.g - this.g) * p + this.g
            }
            if (key == "b") {
                return (color.b - this.b) * p + this.b
            }
            if (key == "a") {
                return (color.a - this.a) * p + this.a
            }
            return 0
        }
        val rgba: UTSJSONObject = object : UTSJSONObject(UTSSourceMapPosition("rgba", "uni_modules/rice-ui/libs/plugin/coloruts/conversion.uts", 347, 15)) {
            var r = Math.round(calc("r"))
            var g = Math.round(calc("g"))
            var b = Math.round(calc("b"))
            var a = Math.round(calc("a") * 100) / 100
        }
        return this._c(rgba)
    }
    open fun tint(amount: Number = 10): Coloruts {
        return this.mix(object : UTSJSONObject() {
            var r: Number = 255
            var g: Number = 255
            var b: Number = 255
            var a: Number = 1
        }, amount)
    }
    open fun shade(amount: Number = 10): Coloruts {
        return this.mix(object : UTSJSONObject() {
            var r: Number = 0
            var g: Number = 0
            var b: Number = 0
            var a: Number = 1
        }, amount)
    }
    open fun darken(amount: Number = 10): Coloruts {
        val h = this.getHue()
        val s = this.getSaturation()
        var l = this.getLightness() - amount / 100
        if (l < 0) {
            l = 0
        }
        return this._c(_uO("h" to h, "s" to s, "l" to l, "a" to this.a))
    }
    open fun lighten(amount: Number = 10): Coloruts {
        val h = this.getHue()
        val s = this.getSaturation()
        var l = this.getLightness() + amount / 100
        if (l > 1) {
            l = 1
        }
        return this._c(_uO("h" to h, "s" to s, "l" to l, "a" to this.a))
    }
    open fun isDark(): Boolean {
        return this.getBrightness() < 128
    }
    open fun isLight(): Boolean {
        return this.getBrightness() >= 128
    }
}
typealias ParseNumber = (num: Number, text: String, index: Number) -> Number
open class Locale (
    @JsonNotNull
    open var weekdays: UTSArray<String>,
    @JsonNotNull
    open var weekdaysShort: UTSArray<String>,
    @JsonNotNull
    open var weekdaysMin: UTSArray<String>,
    @JsonNotNull
    open var months: UTSArray<String>,
    @JsonNotNull
    open var monthsShort: UTSArray<String>,
    open var ordinal: (number: Number, period: String) -> String?,
    @JsonNotNull
    open var weekStart: Number,
    @JsonNotNull
    open var yearStart: Number,
    open var meridiem: (hour: Number, minute: Number) -> String,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("Locale", "uni_modules/rice-ui/libs/plugin/dateuts/locale.uts", 2, 6)
    }
}
val local = Locale(weekdays = _uA(
    "星期日",
    "星期一",
    "星期二",
    "星期三",
    "星期四",
    "星期五",
    "星期六"
), weekdaysShort = _uA(
    "周日",
    "周一",
    "周二",
    "周三",
    "周四",
    "周五",
    "周六"
), weekdaysMin = _uA(
    "日",
    "一",
    "二",
    "三",
    "四",
    "五",
    "六"
), months = _uA(
    "一月",
    "二月",
    "三月",
    "四月",
    "五月",
    "六月",
    "七月",
    "八月",
    "九月",
    "十月",
    "十一月",
    "十二月"
), monthsShort = _uA(
    "1月",
    "2月",
    "3月",
    "4月",
    "5月",
    "6月",
    "7月",
    "8月",
    "9月",
    "10月",
    "11月",
    "12月"
), ordinal = fun(number: Number, period: String): String? {
    when (period) {
        "W" -> 
            return "" + number + "周"
        else -> 
            return "" + number + "日"
    }
}
, weekStart = 1, yearStart = 4, meridiem = fun(hour: Number, minute: Number): String {
    val hm = (hour * 100) + minute
    if (hm < 600) {
        return "凌晨"
    } else if (hm < 900) {
        return "早上"
    } else if (hm < 1100) {
        return "上午"
    } else if (hm < 1300) {
        return "中午"
    } else if (hm < 1800) {
        return "下午"
    }
    return "晚上"
}
)
val wrapper = fun(d: DateType): Dateuts {
    return dateuts(d)
}
val transform2Num = fun(kVal: String?): Number {
    if (kVal == null || kVal == "") {
        return 0
    }
    return parseInt(kVal)
}
val SECONDS_A_MINUTE: Number = 60
typealias DateType = Any
val isDateuts = fun(d: Any): Boolean {
    return d is Dateuts
}
val SECONDS_A_HOUR = SECONDS_A_MINUTE * 60
val SECONDS_A_DAY = SECONDS_A_HOUR * 24
val SECONDS_A_WEEK = SECONDS_A_DAY * 7
val MILLISECONDS_A_SECOND: Number = 1e3
val MILLISECONDS_A_MINUTE = SECONDS_A_MINUTE * MILLISECONDS_A_SECOND
val MILLISECONDS_A_HOUR = SECONDS_A_HOUR * MILLISECONDS_A_SECOND
val MILLISECONDS_A_DAY = SECONDS_A_DAY * MILLISECONDS_A_SECOND
val MILLISECONDS_A_WEEK = SECONDS_A_WEEK * MILLISECONDS_A_SECOND
val INVALID_DATE_STRING = "Invalid Date"
val Y: DateUnits = "year"
val M: DateUnits = "month"
val Q: DateUnits = "quarter"
val D: DateUnits = "day"
val W: DateUnits = "week"
val DATE: DateUnits = "date"
val H: DateUnits = "hour"
val MIN: DateUnits = "minute"
val S: DateUnits = "second"
val padStart = fun(str: Any, len: Number, pad: String): String {
    var s: Any
    if (UTSAndroid.`typeof`(str) == "number") {
        s = (str as Number).toString()
    } else {
        s = str as String
    }
    if ((s as String).length >= len) {
        return s as String
    }
    return (s as String).padStart(len, pad)
}
val MS: DateUnits = "millisecond"
val REGEX_PARSE = UTSRegExp("^(\\d{4})[-/]?(\\d{1,2})?[-/]?(\\d{0,2})[Tt\\s]*(\\d{1,2})?:?(\\d{1,2})?:?(\\d{1,2})?[.:]?(\\d+)?\$", "")
val REGEX_FORMAT = UTSRegExp("\\[([^\\]]+)]|Y{1,4}|M{1,4}|D{1,2}|d{1,4}|H{1,2}|h{1,2}|a|A|m{1,2}|s{1,2}|Z{1,2}|SSS", "g")
val REGEX_ENDWIRHZ = UTSRegExp("Z\$", "i")
val parseDate = fun(params: DateParams?): Date {
    var date = params?.date
    if (date == "" || date == null || date is Dateuts) {
        return Date()
    }
    if (date is Date) {
        return Date((date as Date).toString())
    }
    if (UTSAndroid.`typeof`(date) == "string" && !REGEX_ENDWIRHZ.test(date as String)) {
        val d = (date as String).match(REGEX_PARSE)
        if (d != null) {
            val year = transform2Num(d[1])
            val month = Math.max(transform2Num(d[2]) - 1, 0)
            val day = Math.max(transform2Num(d[3]), 1)
            val hour = transform2Num(d[4])
            val minutes = transform2Num(d[5])
            val seconds = transform2Num(d[6])
            val ms = parseInt(transform2Num(d[7]).toString(10).substring(0, 3))
            return Date(year, month, day, hour, minutes, seconds, ms)
        }
    }
    if (UTSAndroid.`typeof`(date) == "number") {
        return Date(date as Number)
    }
    if (UTSArray.isArray(date)) {
        val newd = (date as UTSArray<Number>).slice() as UTSArray<Number>
        while(newd.length < 7){
            newd.push(0)
        }
        return Date(newd[0], newd[1], Math.max(newd[2], 1), newd[3], newd[4], newd[5], newd[6])
    }
    return Date(date as String)
}
val getShort = fun(arr: UTSArray<String>, index: Number): String {
    return arr[index]
}
val getH = fun(hour: Number, len: Number): String {
    var h = hour % 12
    h = if (h == 0) {
        12
    } else {
        h
    }
    return padStart(h, len, "0")
}
fun monthDiff(a: Dateuts, b: Dateuts): Number {
    if (a.date() < b.date()) {
        return -monthDiff(b, a)
    }
    val ayear = a.year()
    val amonth = a.month()
    val byear = b.year()
    val bmonth = b.month()
    val wholeMonthDiff = ((byear - ayear) * 12) + (bmonth - amonth)
    val anchor = a.clone().add(wholeMonthDiff, M).valueOf()
    val bvalue = b.valueOf()
    val c = bvalue - anchor < 0
    val anchor2 = a.clone().add(wholeMonthDiff + (if (c) {
        -1
    } else {
        1
    }
    ), M).valueOf()
    val diff = (bvalue - anchor) / (if (c) {
        (anchor - anchor2)
    } else {
        (anchor2 - anchor)
    }
    )
    val result = wholeMonthDiff + diff
    val result2 = -result
    val absResult = +result2
    val finalResult = if (!isNaN(absResult)) {
        absResult
    } else {
        0
    }
    return finalResult
}
val absFloor = fun(n: Number): Number {
    return if (n < 0) {
        Math.ceil(n)
    } else {
        Math.floor(n)
    }
}
open class Dateuts : IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("Dateuts", "uni_modules/rice-ui/libs/plugin/dateuts/index.uts", 12, 14)
    }
    private var `$d`: Date
    private var `$y`: Number = 0
    private var `$M`: Number = 0
    private var `$D`: Number = 0
    private var `$W`: Number = 0
    private var `$H`: Number = 0
    private var `$m`: Number = 0
    private var `$s`: Number = 0
    private var `$ms`: Number = 0
    constructor(params: DateParams){
        this.`$d` = parseDate(params)
        this.init()
    }
    private fun init() {
        this.`$y` = this.`$d`.getFullYear()
        this.`$M` = this.`$d`.getMonth()
        this.`$D` = this.`$d`.getDate()
        this.`$W` = this.`$d`.getDay()
        this.`$H` = this.`$d`.getHours()
        this.`$m` = this.`$d`.getMinutes()
        this.`$s` = this.`$d`.getSeconds()
        this.`$ms` = this.`$d`.getMilliseconds()
    }
    open fun valueOf(): Number {
        return this.`$d`.getTime()
    }
    open fun unix(): Number {
        return Math.floor(this.valueOf() / 1000)
    }
    open fun toDate(): Date {
        return Date(this.valueOf())
    }
    open fun clone(): Dateuts {
        return wrapper(this.`$d`)
    }
    open fun startOf(unit: DateUnits, flag: Boolean = true): Dateuts {
        val isStartOf = flag
        val instanceFactory = fun(d: Number, m: Number): Dateuts {
            val ins = dateuts(Date(this.`$y`, m, d))
            return if (isStartOf) {
                ins
            } else {
                ins.endOf(D)
            }
        }
        val instanceFactorySet = fun(method: String, slice: Number): Dateuts {
            val argumentStart: UTSArray<Number> = _uA(
                0,
                0,
                0,
                0
            )
            val argumentEnd: UTSArray<Number> = _uA(
                23,
                59,
                59,
                999
            )
            val arg = (if (isStartOf) {
                argumentStart
            } else {
                argumentEnd
            }
            ).slice(slice)
            val date = this.toDate()
            if (method == "setHours") {
                date.setHours(arg[0])
                date.setMinutes(arg[1])
                date.setSeconds(arg[2])
                date.setMilliseconds(arg[3])
            } else if (method == "setMinutes") {
                date.setMinutes(arg[0])
                date.setSeconds(arg[1])
                date.setMilliseconds(arg[2])
            } else if (method == "setSeconds") {
                date.setSeconds(arg[0])
                date.setMilliseconds(arg[1])
            } else if (method == "setMilliseconds") {
                date.setMilliseconds(arg[0])
            }
            return dateuts(date)
        }
        if (unit == Y) {
            return if (isStartOf) {
                instanceFactory(1, 0)
            } else {
                instanceFactory(31, 11)
            }
        } else if (unit == M) {
            return if (isStartOf) {
                instanceFactory(1, this.`$M`)
            } else {
                instanceFactory(0, this.`$M` + 1)
            }
        } else if (unit == Q) {
            val quarter = this.quarter() - 1
            return if (isStartOf) {
                this.month(quarter * 3).startOf(M).startOf(D)
            } else {
                this.month((quarter * 3) + 2).endOf(M).endOf(D)
            }
        } else if (unit == W) {
            val weekStart = local.weekStart
            val gap = (if (this.`$W` < weekStart) {
                this.`$W` + 7
            } else {
                this.`$W`
            }) - weekStart
            return instanceFactory(if (isStartOf) {
                this.`$D` - gap
            } else {
                this.`$D` + (6 - gap)
            }, this.`$M`)
        } else if (unit == D || unit == DATE) {
            return instanceFactorySet("setHours", 0)
        } else if (unit == H) {
            return instanceFactorySet("setMinutes", 1)
        } else if (unit == MIN) {
            return instanceFactorySet("setSeconds", 2)
        } else if (unit == S) {
            return instanceFactorySet("setMilliseconds", 3)
        }
        return this.clone()
    }
    open fun endOf(unit: DateUnits): Dateuts {
        return this.startOf(unit, false)
    }
    open fun daysInMonth(): Number {
        return this.endOf(M).`$D`
    }
    open fun isValid(): Boolean {
        return !(this.`$d`.toString() == INVALID_DATE_STRING)
    }
    open fun format(formatStr: String): String {
        val matches = fun(match: String): String {
            when (match) {
                "YY" -> 
                    return this.`$y`.toString(10).slice(-2)
                "YYYY" -> 
                    return this.`$y`.toString(10)
                "M" -> 
                    return (this.`$M` + 1).toString(10)
                "MM" -> 
                    return padStart(this.`$M` + 1, 2, "0")
                "MMM" -> 
                    return getShort(local.monthsShort, this.`$M`)
                "MMMM" -> 
                    return getShort(local.months, this.`$M`)
                "D" -> 
                    return this.`$D`.toString(10)
                "DD" -> 
                    return padStart(this.`$D`, 2, "0")
                "d" -> 
                    return this.`$W`.toString(10)
                "dd" -> 
                    return getShort(local.weekdaysMin, this.`$W`)
                "ddd" -> 
                    return getShort(local.weekdaysShort, this.`$W`)
                "dddd" -> 
                    return getShort(local.weekdays, this.`$W`)
                "H" -> 
                    return this.`$H`.toString(10)
                "HH" -> 
                    return padStart(this.`$H`, 2, "0")
                "h" -> 
                    return getH(this.`$H`, 1)
                "hh" -> 
                    return getH(this.`$H`, 2)
                "m" -> 
                    return this.`$m`.toString(10)
                "mm" -> 
                    return padStart(this.`$m`, 2, "0")
                "s" -> 
                    return this.`$s`.toString(10)
                "ss" -> 
                    return padStart(this.`$s`, 2, "0")
                "SSS" -> 
                    return padStart(this.`$ms`, 3, "0")
                else -> 
                    {}
            }
            return ""
        }
        return formatStr.replace(REGEX_FORMAT, fun(match: String, p1: String?, offset: Number, str: String): String {
            if (p1 == null) {
                return matches(match)
            }
            return p1
        }
        )
    }
    private fun utcOffset(): Number {
        return 0
    }
    private fun `$set`(unit: DateUnits, num: Number): Dateuts {
        val arg = if (unit == D) {
            this.`$D` + (num - this.`$W`)
        } else {
            num
        }
        val setDate = fun(date: Dateuts, unit: DateUnits, kVal: Number){
            if (unit == D || unit == DATE) {
                date.`$d`.setDate(kVal)
            } else if (unit == Y) {
                date.`$d`.setFullYear(kVal)
            } else if (unit == M) {
                date.`$d`.setMonth(kVal)
            } else if (unit == H) {
                date.`$d`.setHours(kVal)
            } else if (unit == MIN) {
                date.`$d`.setMinutes(kVal)
            } else if (unit == S) {
                date.`$d`.setSeconds(kVal)
            } else if (unit == MS) {
                date.`$d`.setMilliseconds(kVal)
            }
        }
        if (unit == M || unit == Y) {
            val date = this.clone().set(DATE, 1)
            setDate(date, unit, arg)
            date.init()
            this.`$d` = date.set(DATE, Math.min(this.`$D`, date.daysInMonth())).`$d`
        } else {
            setDate(this, unit, arg)
        }
        this.init()
        return this
    }
    open fun set(str: DateUnits, value: Number): Dateuts {
        return this.clone().`$set`(str, value)
    }
    open fun get(unit: DateUnits): Number {
        if (unit == Y) {
            return this.year()
        }
        if (unit == M) {
            return this.month()
        }
        if (unit == Q) {
            return this.quarter()
        }
        if (unit == D || unit == W) {
            return this.day()
        }
        if (unit == DATE) {
            return this.date()
        }
        if (unit == H) {
            return this.hour()
        }
        if (unit == MIN) {
            return this.minute()
        }
        if (unit == S) {
            return this.second()
        }
        if (unit == MS) {
            return this.millisecond()
        }
        return 0
    }
    open fun year(): Number {
        return this.year(null) as Number
    }
    open fun year(input: Number): Dateuts {
        return this.year(input as Number?) as Dateuts
    }
    open fun year(input: Number?): Any {
        if (input == null) {
            return this.`$y`
        }
        return this.set(Y, input)
    }
    open fun month(): Number {
        return this.month(null) as Number
    }
    open fun month(input: Number): Dateuts {
        return this.month(input as Number?) as Dateuts
    }
    open fun month(input: Number?): Any {
        if (input == null) {
            return this.`$M`
        }
        return this.set(M, input)
    }
    open fun quarter(): Number {
        return this.quarter(null) as Number
    }
    open fun quarter(input: Number): Dateuts {
        return this.quarter(input as Number?) as Dateuts
    }
    open fun quarter(input: Number?): Any {
        val m = this.month()
        if (input == null) {
            return Math.ceil((m + 1) / 3)
        }
        val arg = (m % 3) + ((input - 1) * 3)
        return this.month(arg)
    }
    open fun day(): Number {
        return this.day(null) as Number
    }
    open fun day(input: Number): Dateuts {
        return this.day(input as Number?) as Dateuts
    }
    open fun day(input: Number?): Any {
        if (input == null) {
            return this.`$W`
        }
        return this.set(D, input)
    }
    open fun date(): Number {
        return this.date(null) as Number
    }
    open fun date(input: Number): Dateuts {
        return this.date(input as Number?) as Dateuts
    }
    open fun date(input: Number?): Any {
        if (input == null) {
            return this.`$D`
        }
        return this.set(DATE, input)
    }
    open fun hour(): Number {
        return this.hour(null) as Number
    }
    open fun hour(input: Number): Dateuts {
        return this.hour(input as Number?) as Dateuts
    }
    open fun hour(input: Number?): Any {
        if (input == null) {
            return this.`$H`
        }
        return this.set(H, input)
    }
    open fun minute(): Number {
        return this.minute(null) as Number
    }
    open fun minute(input: Number): Dateuts {
        return this.minute(input as Number?) as Dateuts
    }
    open fun minute(input: Number?): Any {
        if (input == null) {
            return this.`$m`
        }
        return this.set(MIN, input)
    }
    open fun second(): Number {
        return this.second(null) as Number
    }
    open fun second(input: Number): Dateuts {
        return this.second(input as Number?) as Dateuts
    }
    open fun second(input: Number?): Any {
        if (input == null) {
            return this.`$s`
        }
        return this.set(S, input)
    }
    open fun millisecond(): Number {
        return this.millisecond(null) as Number
    }
    open fun millisecond(input: Number): Dateuts {
        return this.millisecond(input as Number?) as Dateuts
    }
    open fun millisecond(input: Number?): Any {
        if (input == null) {
            return this.`$ms`
        }
        return this.set(MS, input)
    }
    open fun add(num: Number, unit: DateUnits): Dateuts {
        val instanceFactorySet = fun(n: Number): Dateuts {
            val d = dateuts(this)
            val ddate = d.date() as Number
            return wrapper(d.date(ddate + Math.round(n * num)))
        }
        if (unit == Y) {
            return this.set(Y, this.`$y` + num)
        }
        if (unit == M) {
            return this.set(M, this.`$M` + num)
        }
        if (unit == Q) {
            return this.add(num * 3, M)
        }
        if (unit == D) {
            return instanceFactorySet(1)
        }
        if (unit == W) {
            return instanceFactorySet(7)
        }
        val stepMap = Map<String, Number>(_uA(
            _uA(
                MIN,
                MILLISECONDS_A_MINUTE
            ),
            _uA(
                H,
                MILLISECONDS_A_HOUR
            ),
            _uA(
                S,
                MILLISECONDS_A_SECOND
            )
        ))
        val step = stepMap.get(unit) ?: 1
        val nextTimeStamp = this.`$d`.getTime() + (num * step)
        return wrapper(nextTimeStamp)
    }
    open fun subtract(num: Number, unit: DateUnits): Dateuts {
        return this.add(num * -1, unit)
    }
    open fun diff(input: Any, unit: DateUnits = "millisecond", float: Boolean = false): Number {
        val that = dateuts(input)
        val zoneDelta = (that.utcOffset() - this.utcOffset()) * MILLISECONDS_A_MINUTE
        val diff = this.valueOf() - that.valueOf()
        val getMonth = fun(): Number {
            return monthDiff(this, that)
        }
        var result: Number
        when (unit) {
            Y -> 
                result = getMonth() / 12
            M -> 
                result = getMonth()
            Q -> 
                result = getMonth() / 3
            W -> 
                result = (diff - zoneDelta) / MILLISECONDS_A_WEEK
            D -> 
                result = (diff - zoneDelta) / MILLISECONDS_A_DAY
            H -> 
                result = diff / MILLISECONDS_A_HOUR
            MIN -> 
                result = diff / MILLISECONDS_A_MINUTE
            S -> 
                result = diff / MILLISECONDS_A_SECOND
            else -> 
                result = diff
        }
        return if (float) {
            result
        } else {
            absFloor(result)
        }
    }
    open fun toArray(): UTSArray<Number> {
        return _uA(
            this.`$y`,
            this.`$M`,
            this.`$D`,
            this.`$H`,
            this.`$m`,
            this.`$s`,
            this.`$ms`
        )
    }
    open fun toObject(): DateObject {
        return DateObject(year = this.`$y`, month = this.`$M`, date = this.`$D`, hours = this.`$H`, minutes = this.`$m`, seconds = this.`$s`, milliseconds = this.`$ms`)
    }
    open fun isBefore(date: Any = "", unit: DateUnits = "millisecond"): Boolean {
        return this.endOf(unit).valueOf() < dateuts(date).valueOf()
    }
    open fun isSame(date: Any = "", unit: DateUnits = "millisecond"): Boolean {
        val other = dateuts(date).valueOf()
        return this.startOf(unit).valueOf() <= other && other <= this.endOf(unit).valueOf()
    }
    open fun isAfter(date: Any = "", unit: DateUnits = "millisecond"): Boolean {
        return dateuts(date).valueOf() < this.startOf(unit).valueOf()
    }
    open fun isSameOrBefore(date: Any = "", unit: DateUnits = "millisecond"): Boolean {
        return this.isSame(date, unit) || this.isBefore(date, unit)
    }
    open fun isSameOrAfter(date: Any = "", unit: DateUnits = "millisecond"): Boolean {
        return this.isSame(date, unit) || this.isAfter(date, unit)
    }
    open fun isBetween(date1: Any = "", date2: Any = "", unit: DateUnits = "millisecond", i: String = "()"): Boolean {
        val dA = dateuts(date1)
        val dB = dateuts(date2)
        var str = if (i.length == 2) {
            i
        } else {
            "()"
        }
        val dAi = str.startsWith("(")
        val dBi = str.endsWith(")")
        return ((if (dAi) {
            this.isAfter(dA, unit)
        } else {
            !this.isBefore(dA, unit)
        }
        ) && (if (dBi) {
            this.isBefore(dB, unit)
        } else {
            !this.isAfter(dB, unit)
        }
        )) || ((if (dAi) {
            this.isBefore(dA, unit)
        } else {
            !this.isAfter(dA, unit)
        }
        ) && (if (dBi) {
            this.isAfter(dB, unit)
        } else {
            !this.isBefore(dB, unit)
        }
        ))
    }
    open fun isLeapYear(): Boolean {
        return ((this.`$y` % 4 == 0) && (this.`$y` % 100 != 0)) || (this.`$y` % 400 == 0)
    }
}
fun dateuts(date: Any = "", customFormat: String = ""): Dateuts {
    if (isDateuts(date)) {
        return (date as Dateuts).clone()
    }
    val params = DateParams(date = date as DateType, customFormat = customFormat)
    return Dateuts(params)
}
open class DateParams (
    @JsonNotNull
    open var date: DateType,
    open var customFormat: String? = null,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("DateParams", "uni_modules/rice-ui/libs/plugin/dateuts/type.uts", 3, 13)
    }
}
open class DateObject (
    @JsonNotNull
    open var year: Number,
    @JsonNotNull
    open var month: Number,
    @JsonNotNull
    open var date: Number,
    @JsonNotNull
    open var hours: Number,
    @JsonNotNull
    open var minutes: Number,
    @JsonNotNull
    open var seconds: Number,
    @JsonNotNull
    open var milliseconds: Number,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("DateObject", "uni_modules/rice-ui/libs/plugin/dateuts/type.uts", 7, 13)
    }
}
typealias DateUnits = String
open class ActionSheetAction (
    @JsonNotNull
    open var name: String,
    open var subname: String? = null,
    open var color: String? = null,
    open var icon: String? = null,
    open var iconSize: Any? = null,
    open var disabled: Boolean? = null,
) : UTSReactiveObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("ActionSheetAction", "uni_modules/rice-ui/components/rice-action-sheet/type.uts", 1, 13)
    }
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return ActionSheetActionReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class ActionSheetActionReactiveObject : ActionSheetAction, IUTSReactive<ActionSheetAction> {
    override var __v_raw: ActionSheetAction
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: ActionSheetAction, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(name = __v_raw.name, subname = __v_raw.subname, color = __v_raw.color, icon = __v_raw.icon, iconSize = __v_raw.iconSize, disabled = __v_raw.disabled) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): ActionSheetActionReactiveObject {
        return ActionSheetActionReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var name: String
        get() {
            return _tRG(__v_raw, "name", __v_raw.name, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("name")) {
                return
            }
            val oldValue = __v_raw.name
            __v_raw.name = value
            _tRS(__v_raw, "name", oldValue, value)
        }
    override var subname: String?
        get() {
            return _tRG(__v_raw, "subname", __v_raw.subname, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("subname")) {
                return
            }
            val oldValue = __v_raw.subname
            __v_raw.subname = value
            _tRS(__v_raw, "subname", oldValue, value)
        }
    override var color: String?
        get() {
            return _tRG(__v_raw, "color", __v_raw.color, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("color")) {
                return
            }
            val oldValue = __v_raw.color
            __v_raw.color = value
            _tRS(__v_raw, "color", oldValue, value)
        }
    override var icon: String?
        get() {
            return _tRG(__v_raw, "icon", __v_raw.icon, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("icon")) {
                return
            }
            val oldValue = __v_raw.icon
            __v_raw.icon = value
            _tRS(__v_raw, "icon", oldValue, value)
        }
    override var iconSize: Any?
        get() {
            return _tRG(__v_raw, "iconSize", __v_raw.iconSize, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("iconSize")) {
                return
            }
            val oldValue = __v_raw.iconSize
            __v_raw.iconSize = value
            _tRS(__v_raw, "iconSize", oldValue, value)
        }
    override var disabled: Boolean?
        get() {
            return _tRG(__v_raw, "disabled", __v_raw.disabled, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("disabled")) {
                return
            }
            val oldValue = __v_raw.disabled
            __v_raw.disabled = value
            _tRS(__v_raw, "disabled", oldValue, value)
        }
}
open class ActionSheetProps (
    open var actions: UTSArray<ActionSheetAction>? = null,
    open var title: String? = null,
    open var showCancel: Boolean? = null,
    open var cancelText: String? = null,
    open var duration: Number? = null,
    open var zIndex: Number? = null,
    open var opacity: Boolean? = null,
    open var overlay: Boolean? = null,
    open var overlayBgColor: String? = null,
    open var closeOnClickAction: Boolean? = null,
    open var closeOnClickOverlay: Boolean? = null,
    open var radius: Any? = null,
    open var safeAreaInsetBottom: Boolean? = null,
    open var useDialogPage: Boolean? = null,
    open var customStyle: UTSJSONObject? = null,
    open var select: ((action: ActionSheetAction, index: Number) -> Unit)? = null,
    open var cancel: (() -> Unit)? = null,
    open var clickOverlay: (() -> Unit)? = null,
    open var open: (() -> Unit)? = null,
    open var close: (() -> Unit)? = null,
    open var opened: (() -> Unit)? = null,
    open var closed: (() -> Unit)? = null,
    open var ready: ((pageIns: UniPage) -> Unit)? = null,
    open var fail: ((errMsg: String) -> Unit)? = null,
) : UTSReactiveObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("ActionSheetProps", "uni_modules/rice-ui/components/rice-action-sheet/type.uts", 9, 13)
    }
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return ActionSheetPropsReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class ActionSheetPropsReactiveObject : ActionSheetProps, IUTSReactive<ActionSheetProps> {
    override var __v_raw: ActionSheetProps
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: ActionSheetProps, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(actions = __v_raw.actions, title = __v_raw.title, showCancel = __v_raw.showCancel, cancelText = __v_raw.cancelText, duration = __v_raw.duration, zIndex = __v_raw.zIndex, opacity = __v_raw.opacity, overlay = __v_raw.overlay, overlayBgColor = __v_raw.overlayBgColor, closeOnClickAction = __v_raw.closeOnClickAction, closeOnClickOverlay = __v_raw.closeOnClickOverlay, radius = __v_raw.radius, safeAreaInsetBottom = __v_raw.safeAreaInsetBottom, useDialogPage = __v_raw.useDialogPage, customStyle = __v_raw.customStyle, select = __v_raw.select, cancel = __v_raw.cancel, clickOverlay = __v_raw.clickOverlay, open = __v_raw.open, close = __v_raw.close, opened = __v_raw.opened, closed = __v_raw.closed, ready = __v_raw.ready, fail = __v_raw.fail) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): ActionSheetPropsReactiveObject {
        return ActionSheetPropsReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var actions: UTSArray<ActionSheetAction>?
        get() {
            return _tRG(__v_raw, "actions", __v_raw.actions, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("actions")) {
                return
            }
            val oldValue = __v_raw.actions
            __v_raw.actions = value
            _tRS(__v_raw, "actions", oldValue, value)
        }
    override var title: String?
        get() {
            return _tRG(__v_raw, "title", __v_raw.title, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("title")) {
                return
            }
            val oldValue = __v_raw.title
            __v_raw.title = value
            _tRS(__v_raw, "title", oldValue, value)
        }
    override var showCancel: Boolean?
        get() {
            return _tRG(__v_raw, "showCancel", __v_raw.showCancel, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("showCancel")) {
                return
            }
            val oldValue = __v_raw.showCancel
            __v_raw.showCancel = value
            _tRS(__v_raw, "showCancel", oldValue, value)
        }
    override var cancelText: String?
        get() {
            return _tRG(__v_raw, "cancelText", __v_raw.cancelText, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("cancelText")) {
                return
            }
            val oldValue = __v_raw.cancelText
            __v_raw.cancelText = value
            _tRS(__v_raw, "cancelText", oldValue, value)
        }
    override var duration: Number?
        get() {
            return _tRG(__v_raw, "duration", __v_raw.duration, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("duration")) {
                return
            }
            val oldValue = __v_raw.duration
            __v_raw.duration = value
            _tRS(__v_raw, "duration", oldValue, value)
        }
    override var zIndex: Number?
        get() {
            return _tRG(__v_raw, "zIndex", __v_raw.zIndex, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("zIndex")) {
                return
            }
            val oldValue = __v_raw.zIndex
            __v_raw.zIndex = value
            _tRS(__v_raw, "zIndex", oldValue, value)
        }
    override var opacity: Boolean?
        get() {
            return _tRG(__v_raw, "opacity", __v_raw.opacity, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("opacity")) {
                return
            }
            val oldValue = __v_raw.opacity
            __v_raw.opacity = value
            _tRS(__v_raw, "opacity", oldValue, value)
        }
    override var overlay: Boolean?
        get() {
            return _tRG(__v_raw, "overlay", __v_raw.overlay, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("overlay")) {
                return
            }
            val oldValue = __v_raw.overlay
            __v_raw.overlay = value
            _tRS(__v_raw, "overlay", oldValue, value)
        }
    override var overlayBgColor: String?
        get() {
            return _tRG(__v_raw, "overlayBgColor", __v_raw.overlayBgColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("overlayBgColor")) {
                return
            }
            val oldValue = __v_raw.overlayBgColor
            __v_raw.overlayBgColor = value
            _tRS(__v_raw, "overlayBgColor", oldValue, value)
        }
    override var closeOnClickAction: Boolean?
        get() {
            return _tRG(__v_raw, "closeOnClickAction", __v_raw.closeOnClickAction, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("closeOnClickAction")) {
                return
            }
            val oldValue = __v_raw.closeOnClickAction
            __v_raw.closeOnClickAction = value
            _tRS(__v_raw, "closeOnClickAction", oldValue, value)
        }
    override var closeOnClickOverlay: Boolean?
        get() {
            return _tRG(__v_raw, "closeOnClickOverlay", __v_raw.closeOnClickOverlay, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("closeOnClickOverlay")) {
                return
            }
            val oldValue = __v_raw.closeOnClickOverlay
            __v_raw.closeOnClickOverlay = value
            _tRS(__v_raw, "closeOnClickOverlay", oldValue, value)
        }
    override var radius: Any?
        get() {
            return _tRG(__v_raw, "radius", __v_raw.radius, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("radius")) {
                return
            }
            val oldValue = __v_raw.radius
            __v_raw.radius = value
            _tRS(__v_raw, "radius", oldValue, value)
        }
    override var safeAreaInsetBottom: Boolean?
        get() {
            return _tRG(__v_raw, "safeAreaInsetBottom", __v_raw.safeAreaInsetBottom, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("safeAreaInsetBottom")) {
                return
            }
            val oldValue = __v_raw.safeAreaInsetBottom
            __v_raw.safeAreaInsetBottom = value
            _tRS(__v_raw, "safeAreaInsetBottom", oldValue, value)
        }
    override var useDialogPage: Boolean?
        get() {
            return _tRG(__v_raw, "useDialogPage", __v_raw.useDialogPage, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("useDialogPage")) {
                return
            }
            val oldValue = __v_raw.useDialogPage
            __v_raw.useDialogPage = value
            _tRS(__v_raw, "useDialogPage", oldValue, value)
        }
    override var customStyle: UTSJSONObject?
        get() {
            return _tRG(__v_raw, "customStyle", __v_raw.customStyle, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("customStyle")) {
                return
            }
            val oldValue = __v_raw.customStyle
            __v_raw.customStyle = value
            _tRS(__v_raw, "customStyle", oldValue, value)
        }
}
open class ActionSheetBusEvent (
    @JsonNotNull
    open var type: String,
    open var action: ActionSheetAction? = null,
    open var index: Number? = null,
    open var errMsg: String? = null,
    open var pageIns: UniPage? = null,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("ActionSheetBusEvent", "uni_modules/rice-ui/components/rice-action-sheet/api.uts", 3, 13)
    }
}
val url = "uni_modules/rice-ui/pages/action-sheet/action-sheet"
val showActionSheet = fun(options: ActionSheetProps){
    val uid = getUID()
    val baseEventName = "rice_action_sheet_" + uid
    val readyEventName = baseEventName + "_ready"
    val optionsEventName = baseEventName + "_options"
    val busEventName = baseEventName + "_bus"
    uni__on(readyEventName, fun(){
        uni__emit(optionsEventName, options)
    }
    )
    uni__on(busEventName, fun(event: ActionSheetBusEvent){
        val type = event.type
        if (type == "select") {
            options.select?.invoke(event.action!!, event.index as Number)
        } else if (type == "cancel") {
            options.cancel?.invoke()
        } else if (type == "open") {
            options.open?.invoke()
        } else if (type == "close") {
            options.close?.invoke()
        } else if (type == "opened") {
            options.opened?.invoke()
        } else if (type == "closed") {
            options.closed?.invoke()
        } else if (type == "ready") {
            options.ready?.invoke(event.pageIns!!)
        } else if (type == "clickOverlay") {
            options.clickOverlay?.invoke()
        } else if (type == "fail") {
            options.fail?.invoke(event.errMsg ?: "")
        }
    }
    )
    uni_openDialogPage(OpenDialogPageOptions(url = "/" + url + "?readyEventName=" + readyEventName + "&optionsEventName=" + optionsEventName + "&busEventName=" + busEventName, fail = fun(err){
        options.fail?.invoke(err.errMsg)
        uni__off(readyEventName, null)
        uni__off(busEventName, null)
        debugWarn("action-sheet", "请在pages.json 中注册" + url + "页面！errMsg:" + err.errMsg)
    }
    ))
}
typealias LoadingMode = String
typealias LoadingTimingFunction = String
val lunarYears: UTSArray<Number> = _uA(
    0x04bd8,
    0x04ae0,
    0x0a570,
    0x054d5,
    0x0d260,
    0x0d950,
    0x16554,
    0x056a0,
    0x09ad0,
    0x055d2,
    0x04ae0,
    0x0a5b6,
    0x0a4d0,
    0x0d250,
    0x1d255,
    0x0b540,
    0x0d6a0,
    0x0ada2,
    0x095b0,
    0x14977,
    0x04970,
    0x0a4b0,
    0x0b4b5,
    0x06a50,
    0x06d40,
    0x1ab54,
    0x02b60,
    0x09570,
    0x052f2,
    0x04970,
    0x06566,
    0x0d4a0,
    0x0ea50,
    0x16a95,
    0x05ad0,
    0x02b60,
    0x186e3,
    0x092e0,
    0x1c8d7,
    0x0c950,
    0x0d4a0,
    0x1d8a6,
    0x0b550,
    0x056a0,
    0x1a5b4,
    0x025d0,
    0x092d0,
    0x0d2b2,
    0x0a950,
    0x0b557,
    0x06ca0,
    0x0b550,
    0x15355,
    0x04da0,
    0x0a5b0,
    0x14573,
    0x052b0,
    0x0a9a8,
    0x0e950,
    0x06aa0,
    0x0aea6,
    0x0ab50,
    0x04b60,
    0x0aae4,
    0x0a570,
    0x05260,
    0x0f263,
    0x0d950,
    0x05b57,
    0x056a0,
    0x096d0,
    0x04dd5,
    0x04ad0,
    0x0a4d0,
    0x0d4d4,
    0x0d250,
    0x0d558,
    0x0b540,
    0x0b6a0,
    0x195a6,
    0x095b0,
    0x049b0,
    0x0a974,
    0x0a4b0,
    0x0b27a,
    0x06a50,
    0x06d40,
    0x0af46,
    0x0ab60,
    0x09570,
    0x04af5,
    0x04970,
    0x064b0,
    0x074a3,
    0x0ea50,
    0x06b58,
    0x05ac0,
    0x0ab60,
    0x096d5,
    0x092e0,
    0x0c960,
    0x0d954,
    0x0d4a0,
    0x0da50,
    0x07552,
    0x056a0,
    0x0abb7,
    0x025d0,
    0x092d0,
    0x0cab5,
    0x0a950,
    0x0b4a0,
    0x0baa4,
    0x0ad50,
    0x055d9,
    0x04ba0,
    0x0a5b0,
    0x15176,
    0x052b0,
    0x0a930,
    0x07954,
    0x06aa0,
    0x0ad50,
    0x05b52,
    0x04b60,
    0x0a6e6,
    0x0a4e0,
    0x0d260,
    0x0ea65,
    0x0d530,
    0x05aa0,
    0x076a3,
    0x096d0,
    0x04afb,
    0x04ad0,
    0x0a4d0,
    0x1d0b6,
    0x0d250,
    0x0d520,
    0x0dd45,
    0x0b5a0,
    0x056d0,
    0x055b2,
    0x049b0,
    0x0a577,
    0x0a4b0,
    0x0aa50,
    0x1b255,
    0x06d20,
    0x0ada0,
    0x14b63,
    0x09370,
    0x049f8,
    0x04970,
    0x064b0,
    0x168a6,
    0x0ea50,
    0x06b20,
    0x1a6c4,
    0x0aae0,
    0x092e0,
    0x0d2e3,
    0x0c960,
    0x0d557,
    0x0d4a0,
    0x0da50,
    0x05d55,
    0x056a0,
    0x0a6d0,
    0x055d4,
    0x052d0,
    0x0a9b8,
    0x0a950,
    0x0b4a0,
    0x0b6a6,
    0x0ad50,
    0x055a0,
    0x0aba4,
    0x0a5b0,
    0x052b0,
    0x0b273,
    0x06930,
    0x07337,
    0x06aa0,
    0x0ad50,
    0x14b55,
    0x04b60,
    0x0a570,
    0x054e4,
    0x0d160,
    0x0e968,
    0x0d520,
    0x0daa0,
    0x16aa6,
    0x056d0,
    0x04ae0,
    0x0a9d4,
    0x0a2d0,
    0x0d150,
    0x0f252,
    0x0d520
)
val N_STR_3 = _uA(
    "\u6708",
    "\u6b63",
    "\u4e8c",
    "\u4e09",
    "\u56db",
    "\u4e94",
    "\u516d",
    "\u4e03",
    "\u516b",
    "\u4e5d",
    "\u5341",
    "\u51ac",
    "\u814a"
)
val N_STR_1 = _uA(
    "\u65e5",
    "\u4e00",
    "\u4e8c",
    "\u4e09",
    "\u56db",
    "\u4e94",
    "\u516d",
    "\u4e03",
    "\u516b",
    "\u4e5d",
    "\u5341"
)
val N_STR_2 = _uA(
    "\u521d",
    "\u5341",
    "\u5eff",
    "\u5345",
    "\u95f0"
)
open class InfoType (
    @JsonNotNull
    open var lunarY: Number,
    @JsonNotNull
    open var lunarM: Number,
    @JsonNotNull
    open var lunarD: Number,
    @JsonNotNull
    open var isLeap: Boolean = false,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("InfoType", "uni_modules/rice-ui/components/rice-calendar/lunar.uts", 49, 13)
    }
}
open class LunarInfoType (
    @JsonNotNull
    open var lYear: Number,
    @JsonNotNull
    open var lMonth: Number,
    @JsonNotNull
    open var lDay: Number,
    @JsonNotNull
    open var IMonthCn: String,
    @JsonNotNull
    open var IDayCn: String,
    @JsonNotNull
    open var cYear: Number,
    @JsonNotNull
    open var cMonth: Number,
    @JsonNotNull
    open var cDay: Number,
    open var gzYear: String? = null,
    open var gzMonth: String? = null,
    open var gzDay: String? = null,
    @JsonNotNull
    open var isToday: Boolean = false,
    @JsonNotNull
    open var isLeap: Boolean = false,
    open var nWeek: Number? = null,
    open var ncWeek: String? = null,
    open var isTerm: Boolean? = null,
    open var Term: String? = null,
    open var astro: String? = null,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("LunarInfoType", "uni_modules/rice-ui/components/rice-calendar/lunar.uts", 55, 13)
    }
}
open class Lunar : IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("Lunar", "uni_modules/rice-ui/components/rice-calendar/lunar.uts", 75, 14)
    }
    private var lunarYearDaysMap = Map<Number, Number>()
    private var lunarMonthDaysMap = Map<Number, UTSArray<Number>>()
    constructor(){}
    open fun toChinaMonth(m: Number, leap: Boolean = false): String {
        return if (leap) {
            (N_STR_3[4] + N_STR_3[m] + N_STR_3[0])
        } else {
            (N_STR_3[m] + N_STR_3[0])
        }
    }
    open fun toChinaDay(d: Number): String {
        var s: String
        when (d) {
            10 -> 
                s = "\u521d\u5341"
            20 -> 
                s = "\u4e8c\u5341"
            30 -> 
                s = "\u4e09\u5341"
            else -> 
                {
                    s = N_STR_2[Math.floor(d / 10)]
                    s += N_STR_1[d % 10]
                }
        }
        return s
    }
    open fun leapMonth(year: Number): Number {
        return lunarYears[year - 1900] and 0xF
    }
    open fun leapDays(year: Number): Number {
        if (this.leapMonth(year) > 0) {
            return if ((lunarYears[year - 1900] and 0x10000) != 0) {
                30
            } else {
                29
            }
        }
        return 0
    }
    open fun lunarMonthDays(year: Number): UTSArray<Number> {
        var monthDays = this.lunarMonthDaysMap.get(year)
        if (monthDays != null) {
            return monthDays
        }
        monthDays = _uA()
        var lunarYear = lunarYears[year - 1900]
        run {
            var i: Number = 15
            while(i >= 4){
                var monthDay = if ((lunarYear shr i and 0x1) != 0) {
                    30
                } else {
                    29
                }
                monthDays.push(monthDay)
                i--
            }
        }
        var leapM = this.leapMonth(year)
        if (leapM > 0) {
            monthDays.splice(leapM, 0, this.leapDays(year))
        }
        this.lunarMonthDaysMap.set(year, monthDays)
        return monthDays
    }
    open fun lunarYearDays(year: Number): Number {
        if (this.lunarYearDaysMap.has(year)) {
            return this.lunarYearDaysMap.get(year)!!
        }
        var num: Number = 0
        this.lunarMonthDays(year).forEach(fun(item){
            num += item
        }
        )
        this.lunarYearDaysMap.set(year, num)
        return num
    }
    open fun solar2lunar(y: Number, m: Number, d: Number): LunarInfoType {
        var moonDay = this.solar_date(y, m, d)
        var lYear = moonDay.lunarY
        var lMonth = moonDay.lunarM
        var lDay = moonDay.lunarD
        var isLeap = moonDay.isLeap
        val IMonthCn = this.toChinaMonth(lMonth, isLeap)
        var IDayCn = if (lDay == 1) {
            IMonthCn
        } else {
            this.toChinaDay(lDay)
        }
        var isTodayObj = Date()
        var isToday = false
        if (isTodayObj.getFullYear() == y && isTodayObj.getMonth() + 1 == m && isTodayObj.getDate() == d) {
            isToday = true
        }
        var info = LunarInfoType(lYear = lYear, lMonth = lMonth, lDay = lDay, IMonthCn = IMonthCn, IDayCn = IDayCn, cYear = y, cMonth = m, cDay = d, isToday = isToday, isLeap = isLeap)
        return info
    }
    open fun solar_date(y: Number, m: Number, d: Number): InfoType {
        var date = Date(y, m - 1, d)
        var offset = (Date.UTC(date.getFullYear(), date.getMonth(), date.getDate()) - Date.UTC(1901, 1, 19)) / 86400000
        var temp: Number = 0
        var i: Number
        run {
            i = 1901
            while(i < 2101 && offset > 0){
                temp = this.lunarYearDays(i)
                offset -= temp
                i++
            }
        }
        if (offset < 0) {
            offset += temp
            i--
        }
        var isLeap: Boolean = false
        var j: Number = 0
        var monthDays = this.lunarMonthDays(i)
        var leapM = this.leapMonth(i)
        if (offset > 0) {
            run {
                j = 0
                while(j < monthDays.length && offset > 0){
                    temp = monthDays[j]
                    offset -= temp
                    j++
                }
            }
            if (offset == 0) {
                j++
            }
            if (offset < 0) {
                offset += temp
            }
        } else {
            if (offset == -23) {}
        }
        if (leapM > 0) {
            if (j == leapM + 1) {
                isLeap = true
            }
            if (j >= leapM + 1) {
                j--
            }
        }
        val info = InfoType(lunarY = i, lunarM = j, lunarD = ++offset, isLeap = isLeap)
        return info
    }
}
open class CascaderOption (
    @JsonNotNull
    open var text: String,
    @JsonNotNull
    open var value: Any,
    open var disabled: Boolean? = null,
    open var children: UTSArray<CascaderOption>? = null,
    open var extend: Any? = null,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("CascaderOption", "uni_modules/rice-ui/components/rice-cascader/type.uts", 1, 13)
    }
}
val checkboxGroupInjectKey = "CheckboxGroupKey-" + getRandomStr()
open class PickerOption (
    @JsonNotNull
    open var text: Any,
    @JsonNotNull
    open var value: Any,
    open var disabled: Boolean? = null,
    open var children: UTSArray<PickerOption>? = null,
    open var extend: UTSJSONObject? = null,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("PickerOption", "uni_modules/rice-ui/components/rice-picker/type.uts", 1, 13)
    }
}
open class DialogProps (
    open var title: String? = null,
    open var width: Any? = null,
    open var message: String? = null,
    open var messageAlign: String? = null,
    open var buttonTheme: String? = null,
    open var buttonLayout: String? = null,
    open var showConfirmButton: Boolean? = null,
    open var confirmButtonText: String? = null,
    open var confirmButtonColor: String? = null,
    open var confirmButtonDisabled: Boolean? = null,
    open var showCancelButton: Boolean? = null,
    open var cancelButtonText: String? = null,
    open var cancelButtonColor: String? = null,
    open var cancelButtonDisabled: Boolean? = null,
    open var duration: Number? = null,
    open var overlay: Boolean? = null,
    open var overlayBgColor: String? = null,
    open var closeOnClickOverlay: Boolean? = null,
    open var beforeClose: BeforeChangeInterceptor? = null,
    open var zIndex: Number? = null,
    open var bgColor: String? = null,
    open var marginTop: Any? = null,
    open var useDialogPage: Boolean? = null,
    open var customStyle: UTSJSONObject? = null,
    open var confirm: (() -> Unit)? = null,
    open var cancel: (() -> Unit)? = null,
    open var clickOverlay: (() -> Unit)? = null,
    open var open: (() -> Unit)? = null,
    open var close: (() -> Unit)? = null,
    open var opened: (() -> Unit)? = null,
    open var closed: (() -> Unit)? = null,
    open var ready: ((pageIns: UniPage) -> Unit)? = null,
    open var fail: ((errMsg: String) -> Unit)? = null,
) : UTSReactiveObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("DialogProps", "uni_modules/rice-ui/components/rice-dialog/type.uts", 2, 13)
    }
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return DialogPropsReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class DialogPropsReactiveObject : DialogProps, IUTSReactive<DialogProps> {
    override var __v_raw: DialogProps
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: DialogProps, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(title = __v_raw.title, width = __v_raw.width, message = __v_raw.message, messageAlign = __v_raw.messageAlign, buttonTheme = __v_raw.buttonTheme, buttonLayout = __v_raw.buttonLayout, showConfirmButton = __v_raw.showConfirmButton, confirmButtonText = __v_raw.confirmButtonText, confirmButtonColor = __v_raw.confirmButtonColor, confirmButtonDisabled = __v_raw.confirmButtonDisabled, showCancelButton = __v_raw.showCancelButton, cancelButtonText = __v_raw.cancelButtonText, cancelButtonColor = __v_raw.cancelButtonColor, cancelButtonDisabled = __v_raw.cancelButtonDisabled, duration = __v_raw.duration, overlay = __v_raw.overlay, overlayBgColor = __v_raw.overlayBgColor, closeOnClickOverlay = __v_raw.closeOnClickOverlay, beforeClose = __v_raw.beforeClose, zIndex = __v_raw.zIndex, bgColor = __v_raw.bgColor, marginTop = __v_raw.marginTop, useDialogPage = __v_raw.useDialogPage, customStyle = __v_raw.customStyle, confirm = __v_raw.confirm, cancel = __v_raw.cancel, clickOverlay = __v_raw.clickOverlay, open = __v_raw.open, close = __v_raw.close, opened = __v_raw.opened, closed = __v_raw.closed, ready = __v_raw.ready, fail = __v_raw.fail) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): DialogPropsReactiveObject {
        return DialogPropsReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var title: String?
        get() {
            return _tRG(__v_raw, "title", __v_raw.title, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("title")) {
                return
            }
            val oldValue = __v_raw.title
            __v_raw.title = value
            _tRS(__v_raw, "title", oldValue, value)
        }
    override var width: Any?
        get() {
            return _tRG(__v_raw, "width", __v_raw.width, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("width")) {
                return
            }
            val oldValue = __v_raw.width
            __v_raw.width = value
            _tRS(__v_raw, "width", oldValue, value)
        }
    override var message: String?
        get() {
            return _tRG(__v_raw, "message", __v_raw.message, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("message")) {
                return
            }
            val oldValue = __v_raw.message
            __v_raw.message = value
            _tRS(__v_raw, "message", oldValue, value)
        }
    override var messageAlign: String?
        get() {
            return _tRG(__v_raw, "messageAlign", __v_raw.messageAlign, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("messageAlign")) {
                return
            }
            val oldValue = __v_raw.messageAlign
            __v_raw.messageAlign = value
            _tRS(__v_raw, "messageAlign", oldValue, value)
        }
    override var buttonTheme: String?
        get() {
            return _tRG(__v_raw, "buttonTheme", __v_raw.buttonTheme, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("buttonTheme")) {
                return
            }
            val oldValue = __v_raw.buttonTheme
            __v_raw.buttonTheme = value
            _tRS(__v_raw, "buttonTheme", oldValue, value)
        }
    override var buttonLayout: String?
        get() {
            return _tRG(__v_raw, "buttonLayout", __v_raw.buttonLayout, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("buttonLayout")) {
                return
            }
            val oldValue = __v_raw.buttonLayout
            __v_raw.buttonLayout = value
            _tRS(__v_raw, "buttonLayout", oldValue, value)
        }
    override var showConfirmButton: Boolean?
        get() {
            return _tRG(__v_raw, "showConfirmButton", __v_raw.showConfirmButton, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("showConfirmButton")) {
                return
            }
            val oldValue = __v_raw.showConfirmButton
            __v_raw.showConfirmButton = value
            _tRS(__v_raw, "showConfirmButton", oldValue, value)
        }
    override var confirmButtonText: String?
        get() {
            return _tRG(__v_raw, "confirmButtonText", __v_raw.confirmButtonText, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("confirmButtonText")) {
                return
            }
            val oldValue = __v_raw.confirmButtonText
            __v_raw.confirmButtonText = value
            _tRS(__v_raw, "confirmButtonText", oldValue, value)
        }
    override var confirmButtonColor: String?
        get() {
            return _tRG(__v_raw, "confirmButtonColor", __v_raw.confirmButtonColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("confirmButtonColor")) {
                return
            }
            val oldValue = __v_raw.confirmButtonColor
            __v_raw.confirmButtonColor = value
            _tRS(__v_raw, "confirmButtonColor", oldValue, value)
        }
    override var confirmButtonDisabled: Boolean?
        get() {
            return _tRG(__v_raw, "confirmButtonDisabled", __v_raw.confirmButtonDisabled, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("confirmButtonDisabled")) {
                return
            }
            val oldValue = __v_raw.confirmButtonDisabled
            __v_raw.confirmButtonDisabled = value
            _tRS(__v_raw, "confirmButtonDisabled", oldValue, value)
        }
    override var showCancelButton: Boolean?
        get() {
            return _tRG(__v_raw, "showCancelButton", __v_raw.showCancelButton, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("showCancelButton")) {
                return
            }
            val oldValue = __v_raw.showCancelButton
            __v_raw.showCancelButton = value
            _tRS(__v_raw, "showCancelButton", oldValue, value)
        }
    override var cancelButtonText: String?
        get() {
            return _tRG(__v_raw, "cancelButtonText", __v_raw.cancelButtonText, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("cancelButtonText")) {
                return
            }
            val oldValue = __v_raw.cancelButtonText
            __v_raw.cancelButtonText = value
            _tRS(__v_raw, "cancelButtonText", oldValue, value)
        }
    override var cancelButtonColor: String?
        get() {
            return _tRG(__v_raw, "cancelButtonColor", __v_raw.cancelButtonColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("cancelButtonColor")) {
                return
            }
            val oldValue = __v_raw.cancelButtonColor
            __v_raw.cancelButtonColor = value
            _tRS(__v_raw, "cancelButtonColor", oldValue, value)
        }
    override var cancelButtonDisabled: Boolean?
        get() {
            return _tRG(__v_raw, "cancelButtonDisabled", __v_raw.cancelButtonDisabled, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("cancelButtonDisabled")) {
                return
            }
            val oldValue = __v_raw.cancelButtonDisabled
            __v_raw.cancelButtonDisabled = value
            _tRS(__v_raw, "cancelButtonDisabled", oldValue, value)
        }
    override var duration: Number?
        get() {
            return _tRG(__v_raw, "duration", __v_raw.duration, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("duration")) {
                return
            }
            val oldValue = __v_raw.duration
            __v_raw.duration = value
            _tRS(__v_raw, "duration", oldValue, value)
        }
    override var overlay: Boolean?
        get() {
            return _tRG(__v_raw, "overlay", __v_raw.overlay, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("overlay")) {
                return
            }
            val oldValue = __v_raw.overlay
            __v_raw.overlay = value
            _tRS(__v_raw, "overlay", oldValue, value)
        }
    override var overlayBgColor: String?
        get() {
            return _tRG(__v_raw, "overlayBgColor", __v_raw.overlayBgColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("overlayBgColor")) {
                return
            }
            val oldValue = __v_raw.overlayBgColor
            __v_raw.overlayBgColor = value
            _tRS(__v_raw, "overlayBgColor", oldValue, value)
        }
    override var closeOnClickOverlay: Boolean?
        get() {
            return _tRG(__v_raw, "closeOnClickOverlay", __v_raw.closeOnClickOverlay, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("closeOnClickOverlay")) {
                return
            }
            val oldValue = __v_raw.closeOnClickOverlay
            __v_raw.closeOnClickOverlay = value
            _tRS(__v_raw, "closeOnClickOverlay", oldValue, value)
        }
    override var zIndex: Number?
        get() {
            return _tRG(__v_raw, "zIndex", __v_raw.zIndex, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("zIndex")) {
                return
            }
            val oldValue = __v_raw.zIndex
            __v_raw.zIndex = value
            _tRS(__v_raw, "zIndex", oldValue, value)
        }
    override var bgColor: String?
        get() {
            return _tRG(__v_raw, "bgColor", __v_raw.bgColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("bgColor")) {
                return
            }
            val oldValue = __v_raw.bgColor
            __v_raw.bgColor = value
            _tRS(__v_raw, "bgColor", oldValue, value)
        }
    override var marginTop: Any?
        get() {
            return _tRG(__v_raw, "marginTop", __v_raw.marginTop, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("marginTop")) {
                return
            }
            val oldValue = __v_raw.marginTop
            __v_raw.marginTop = value
            _tRS(__v_raw, "marginTop", oldValue, value)
        }
    override var useDialogPage: Boolean?
        get() {
            return _tRG(__v_raw, "useDialogPage", __v_raw.useDialogPage, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("useDialogPage")) {
                return
            }
            val oldValue = __v_raw.useDialogPage
            __v_raw.useDialogPage = value
            _tRS(__v_raw, "useDialogPage", oldValue, value)
        }
    override var customStyle: UTSJSONObject?
        get() {
            return _tRG(__v_raw, "customStyle", __v_raw.customStyle, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("customStyle")) {
                return
            }
            val oldValue = __v_raw.customStyle
            __v_raw.customStyle = value
            _tRS(__v_raw, "customStyle", oldValue, value)
        }
}
open class DialogBusEvent (
    @JsonNotNull
    open var type: String,
    open var errMsg: String? = null,
    open var pageIns: UniPage? = null,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("DialogBusEvent", "uni_modules/rice-ui/components/rice-dialog/api.uts", 3, 13)
    }
}
val url__1 = "uni_modules/rice-ui/pages/dialog/dialog"
val showDialog = fun(options: DialogProps){
    val uid = getUID()
    val baseEventName = "rice_dialog_" + uid
    val readyEventName = baseEventName + "_ready"
    val optionsEventName = baseEventName + "_options"
    val busEventName = baseEventName + "_bus"
    uni__on(readyEventName, fun(){
        uni__emit(optionsEventName, options)
    }
    )
    uni__on(busEventName, fun(event: DialogBusEvent){
        val type = event.type
        if (type == "confirm") {
            options.confirm?.invoke()
        } else if (type == "cancel") {
            options.cancel?.invoke()
        } else if (type == "open") {
            options.open?.invoke()
        } else if (type == "close") {
            options.close?.invoke()
        } else if (type == "opened") {
            options.opened?.invoke()
        } else if (type == "closed") {
            options.closed?.invoke()
        } else if (type == "ready") {
            options.ready?.invoke(event.pageIns!!)
        } else if (type == "clickOverlay") {
            options.clickOverlay?.invoke()
        } else if (type == "fail") {
            options.fail?.invoke(event.errMsg ?: "")
        }
    }
    )
    uni_openDialogPage(OpenDialogPageOptions(url = "/" + url__1 + "?readyEventName=" + readyEventName + "&optionsEventName=" + optionsEventName + "&busEventName=" + busEventName, fail = fun(err){
        options.fail?.invoke(err.errMsg)
        uni__off(readyEventName, null)
        uni__off(busEventName, null)
        debugWarn("action-sheet", "请在pages.json 中注册" + url__1 + "页面！errMsg:" + err.errMsg)
    }
    ))
}
open class FontData (
    @JsonNotNull
    open var name: String,
    @JsonNotNull
    open var code: String,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("FontData", "uni_modules/rice-ui/components/rice-icon/font.uts", 1, 13)
    }
}
val fontData = _uA(
    FontData(name = "arrow-up", code = "\ueaa4"),
    FontData(name = "arrow-down", code = "\ueaa1"),
    FontData(name = "arrow-left", code = "\ueaa2"),
    FontData(name = "arrow-right", code = "\ueaa3"),
    FontData(name = "up", code = "\ueab1"),
    FontData(name = "down", code = "\ueaa5"),
    FontData(name = "left", code = "\ueaa9"),
    FontData(name = "right", code = "\ueaab"),
    FontData(name = "back-top", code = "\ueaae"),
    FontData(name = "back-bottom", code = "\ueaad"),
    FontData(name = "double-right", code = "\ueaa0"),
    FontData(name = "double-left", code = "\ueaa7"),
    FontData(name = "minus", code = "\uea7e"),
    FontData(name = "plus", code = "\uea7d"),
    FontData(name = "search", code = "\uea8c"),
    FontData(name = "search-fill", code = "\uea89"),
    FontData(name = "scan", code = "\uea67"),
    FontData(name = "qr", code = "\ue6d8"),
    FontData(name = "sort", code = "\ue6e2"),
    FontData(name = "sort-menu", code = "\ueaac"),
    FontData(name = "bars", code = "\ue69f"),
    FontData(name = "remind-disabled", code = "\uea95"),
    FontData(name = "remind", code = "\uea96"),
    FontData(name = "volume", code = "\uea7c"),
    FontData(name = "volume-fill", code = "\uea6f"),
    FontData(name = "volume-up", code = "\uea78"),
    FontData(name = "volume-up-fill", code = "\uea70"),
    FontData(name = "volume-down", code = "\uea79"),
    FontData(name = "volume-down-fill", code = "\uea73"),
    FontData(name = "volume-mute", code = "\uea7a"),
    FontData(name = "volume-mute-fill", code = "\uea72"),
    FontData(name = "voice", code = "\uea77"),
    FontData(name = "voice-off", code = "\uea7b"),
    FontData(name = "play", code = "\uea76"),
    FontData(name = "play-fill", code = "\uea71"),
    FontData(name = "pause", code = "\uea75"),
    FontData(name = "pause-fill", code = "\uea6e"),
    FontData(name = "headset", code = "\uea74"),
    FontData(name = "headset-fill", code = "\uea6d"),
    FontData(name = "user", code = "\ueb30"),
    FontData(name = "peoples", code = "\ueb2f"),
    FontData(name = "peoples-fill", code = "\ueb2c"),
    FontData(name = "trophy", code = "\ueb35"),
    FontData(name = "trophy-fill", code = "\ueb33"),
    FontData(name = "add", code = "\uea84"),
    FontData(name = "add-fill", code = "\uea7f"),
    FontData(name = "reduce", code = "\uea87"),
    FontData(name = "reduce-fill", code = "\uea81"),
    FontData(name = "checked-circle", code = "\uea86"),
    FontData(name = "checked-circle-fill", code = "\uea80"),
    FontData(name = "help", code = "\uea8a"),
    FontData(name = "help-fill", code = "\uea82"),
    FontData(name = "info", code = "\uea88"),
    FontData(name = "info-fill", code = "\uea83"),
    FontData(name = "cross", code = "\uea85"),
    FontData(name = "checked", code = "\ue659"),
    FontData(name = "camera", code = "\uea8f"),
    FontData(name = "camera-fill", code = "\uea8b"),
    FontData(name = "app", code = "\uea91"),
    FontData(name = "app-fill", code = "\uea8d"),
    FontData(name = "like", code = "\uea90"),
    FontData(name = "like-fill", code = "\uea8e"),
    FontData(name = "eyes", code = "\uea92"),
    FontData(name = "eyes-close", code = "\uea94"),
    FontData(name = "sleep", code = "\uea93"),
    FontData(name = "sun", code = "\ueafe"),
    FontData(name = "menu-fold", code = "\uea9e"),
    FontData(name = "menu-unfold", code = "\uea9f"),
    FontData(name = "upload", code = "\ueab2"),
    FontData(name = "download", code = "\ueaa6"),
    FontData(name = "full-screen", code = "\ueaa8"),
    FontData(name = "off-screen", code = "\ueaaa"),
    FontData(name = "switch", code = "\ueaaf"),
    FontData(name = "revoke", code = "\ueab0"),
    FontData(name = "comments", code = "\ueac3"),
    FontData(name = "comments-fill", code = "\ueac2"),
    FontData(name = "phone-call", code = "\ueaba"),
    FontData(name = "phone-call-fill", code = "\ueab4"),
    FontData(name = "phone-in", code = "\ueabc"),
    FontData(name = "phone-in-fill", code = "\ueab5"),
    FontData(name = "phone-out", code = "\ueabb"),
    FontData(name = "phone-out-fill", code = "\ueab6"),
    FontData(name = "phone", code = "\ueabd"),
    FontData(name = "phone-fill", code = "\ueab7"),
    FontData(name = "phone-missed", code = "\ueabe"),
    FontData(name = "phone-missed-fill", code = "\ueab8"),
    FontData(name = "location", code = "\ueac0"),
    FontData(name = "location-fill", code = "\ueabf"),
    FontData(name = "bluetooth", code = "\ueacb"),
    FontData(name = "calendar", code = "\uead4"),
    FontData(name = "calendar-fill", code = "\uead2"),
    FontData(name = "clear", code = "\ueb34"),
    FontData(name = "clear-fill", code = "\ueb32"),
    FontData(name = "share", code = "\uea4e"),
    FontData(name = "share-fill", code = "\uea3d"),
    FontData(name = "edit", code = "\uea48"),
    FontData(name = "delete", code = "\uea45"),
    FontData(name = "delete-fill", code = "\uea37"),
    FontData(name = "shopping", code = "\uea68"),
    FontData(name = "shopping-fill", code = "\uea62"),
    FontData(name = "wallet", code = "\uea69"),
    FontData(name = "bag", code = "\uea6a"),
    FontData(name = "set", code = "\ue6dc"),
    FontData(name = "set-fill", code = "\ue6db"),
    FontData(name = "replay", code = "\ue6dd"),
    FontData(name = "home", code = "\ue6e9"),
    FontData(name = "home-fill", code = "\ue6e8"),
    FontData(name = "chat", code = "\ue6aa"),
    FontData(name = "chat-fill", code = "\ue6a3"),
    FontData(name = "good", code = "\ue6c3"),
    FontData(name = "good-fill", code = "\ue6c2"),
    FontData(name = "gift", code = "\ue6d4"),
    FontData(name = "gift-fill", code = "\ue6d3"),
    FontData(name = "loading", code = "\ue670"),
    FontData(name = "photo", code = "\ue6cf"),
    FontData(name = "photo-fail", code = "\ue6cd"),
    FontData(name = "star", code = "\ue6ec"),
    FontData(name = "star-fill", code = "\ue6ed"),
    FontData(name = "trend", code = "\uea6b"),
    FontData(name = "trend-fill", code = "\uea63"),
    FontData(name = "file-success-fill", code = "\uea25"),
    FontData(name = "file-success", code = "\uea2d")
) as UTSArray<FontData>
val formInjectKey = "FormKey-" + getRandomStr()
val formDataInjectKey = "FormDataKey-" + getRandomStr()
val formDisabledInjectKey = "FormDisabledContextKey-" + getRandomStr()
val formReadonlyInjectKey = "FormReadonlyContextKey-" + getRandomStr()
val formItemContextInjectKey = "FormItemContextKey-" + getRandomStr()
val formItemBlurInjectKey = "FormItemBlurKey-" + getRandomStr()
val radioGroupInjectKey = "RdioGroupKey-" + getRandomStr()
val swipeActionsName = "SwipeActions"
val swipeActionsInjectKey = "SwipeActionsKey-" + getRandomStr()
open class UserInfo (
    @JsonNotNull
    open var nickName: String,
    open var avatarUrl: String? = null,
) : UTSReactiveObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("UserInfo", "store/index.uts", 2, 13)
    }
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return UserInfoReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class UserInfoReactiveObject : UserInfo, IUTSReactive<UserInfo> {
    override var __v_raw: UserInfo
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: UserInfo, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(nickName = __v_raw.nickName, avatarUrl = __v_raw.avatarUrl) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UserInfoReactiveObject {
        return UserInfoReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var nickName: String
        get() {
            return _tRG(__v_raw, "nickName", __v_raw.nickName, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("nickName")) {
                return
            }
            val oldValue = __v_raw.nickName
            __v_raw.nickName = value
            _tRS(__v_raw, "nickName", oldValue, value)
        }
    override var avatarUrl: String?
        get() {
            return _tRG(__v_raw, "avatarUrl", __v_raw.avatarUrl, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("avatarUrl")) {
                return
            }
            val oldValue = __v_raw.avatarUrl
            __v_raw.avatarUrl = value
            _tRS(__v_raw, "avatarUrl", oldValue, value)
        }
}
open class State (
    @JsonNotNull
    open var statusBarHeight: Number,
    @JsonNotNull
    open var devicePixelRatio: Number,
    @JsonNotNull
    open var active: String,
    @JsonNotNull
    open var leftWinActive: String,
    open var agreeToPrivacy: Boolean? = null,
    @JsonNotNull
    open var appTheme: String,
    @JsonNotNull
    open var netless: Boolean = false,
    open var userInfo: UserInfo? = null,
) : UTSReactiveObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("State", "store/index.uts", 6, 6)
    }
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return StateReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class StateReactiveObject : State, IUTSReactive<State> {
    override var __v_raw: State
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: State, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(statusBarHeight = __v_raw.statusBarHeight, devicePixelRatio = __v_raw.devicePixelRatio, active = __v_raw.active, leftWinActive = __v_raw.leftWinActive, agreeToPrivacy = __v_raw.agreeToPrivacy, appTheme = __v_raw.appTheme, netless = __v_raw.netless, userInfo = __v_raw.userInfo) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): StateReactiveObject {
        return StateReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var statusBarHeight: Number
        get() {
            return _tRG(__v_raw, "statusBarHeight", __v_raw.statusBarHeight, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("statusBarHeight")) {
                return
            }
            val oldValue = __v_raw.statusBarHeight
            __v_raw.statusBarHeight = value
            _tRS(__v_raw, "statusBarHeight", oldValue, value)
        }
    override var devicePixelRatio: Number
        get() {
            return _tRG(__v_raw, "devicePixelRatio", __v_raw.devicePixelRatio, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("devicePixelRatio")) {
                return
            }
            val oldValue = __v_raw.devicePixelRatio
            __v_raw.devicePixelRatio = value
            _tRS(__v_raw, "devicePixelRatio", oldValue, value)
        }
    override var active: String
        get() {
            return _tRG(__v_raw, "active", __v_raw.active, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("active")) {
                return
            }
            val oldValue = __v_raw.active
            __v_raw.active = value
            _tRS(__v_raw, "active", oldValue, value)
        }
    override var leftWinActive: String
        get() {
            return _tRG(__v_raw, "leftWinActive", __v_raw.leftWinActive, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("leftWinActive")) {
                return
            }
            val oldValue = __v_raw.leftWinActive
            __v_raw.leftWinActive = value
            _tRS(__v_raw, "leftWinActive", oldValue, value)
        }
    override var agreeToPrivacy: Boolean?
        get() {
            return _tRG(__v_raw, "agreeToPrivacy", __v_raw.agreeToPrivacy, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("agreeToPrivacy")) {
                return
            }
            val oldValue = __v_raw.agreeToPrivacy
            __v_raw.agreeToPrivacy = value
            _tRS(__v_raw, "agreeToPrivacy", oldValue, value)
        }
    override var appTheme: String
        get() {
            return _tRG(__v_raw, "appTheme", __v_raw.appTheme, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("appTheme")) {
                return
            }
            val oldValue = __v_raw.appTheme
            __v_raw.appTheme = value
            _tRS(__v_raw, "appTheme", oldValue, value)
        }
    override var netless: Boolean
        get() {
            return _tRG(__v_raw, "netless", __v_raw.netless, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("netless")) {
                return
            }
            val oldValue = __v_raw.netless
            __v_raw.netless = value
            _tRS(__v_raw, "netless", oldValue, value)
        }
    override var userInfo: UserInfo?
        get() {
            return _tRG(__v_raw, "userInfo", __v_raw.userInfo, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("userInfo")) {
                return
            }
            val oldValue = __v_raw.userInfo
            __v_raw.userInfo = value
            _tRS(__v_raw, "userInfo", oldValue, value)
        }
}
val state = reactive(State(statusBarHeight = 56, devicePixelRatio = 1, active = "componentPage", leftWinActive = "/pages/component/view/view", appTheme = "light", netless = false, userInfo = null))
val setAppTheme = fun(appTheme: String){
    state.appTheme = appTheme as String
}
val checkSystemTheme = fun(){
    uni_getSystemInfo(GetSystemInfoOptions(success = fun(res: GetSystemInfoResult){
        val appTheme = if (res.appTheme == "auto") {
            res.osTheme!!
        } else {
            res.appTheme!!
        }
        state.appTheme = appTheme.trim() ?: "light"
    }
    ))
    uni_onAppThemeChange(fun(res: AppThemeChangeResult){
        state.appTheme = res.appTheme.trim() ?: "light"
    }
    )
    setTheme(state.appTheme)
}
var firstBackTime: Number = 0
open class GenApp : BaseApp {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onLaunch(fun(_: OnLaunchOptions) {
            console.log("App Launch", " at App.uvue:8")
            checkSystemTheme()
        }
        , __ins)
        onAppShow(fun(_: OnShowOptions) {
            console.log("App Show", " at App.uvue:12")
        }
        , __ins)
        onAppHide(fun() {
            console.log("App Hide", " at App.uvue:15")
        }
        , __ins)
        onLastPageBackPress(fun() {
            console.log("App LastPageBackPress", " at App.uvue:19")
            if (firstBackTime == 0) {
                uni_showToast(ShowToastOptions(title = "再按一次退出应用", position = "bottom"))
                firstBackTime = Date.now()
                setTimeout(fun(){
                    firstBackTime = 0
                }, 2000)
            } else if (Date.now() - firstBackTime < 2000) {
                firstBackTime = Date.now()
                uni_exit(null)
            }
        }
        , __ins)
        onExit(fun() {
            console.log("App Exit", " at App.uvue:36")
        }
        , __ins)
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("rice-safe-area-top" to _pS(_uM("paddingBottom" to "var(--uni-safe-area-inset-top)")), "rice-safe-area-bottom" to _pS(_uM("paddingBottom" to "var(--uni-safe-area-inset-bottom)")), "rice-theme-light" to _pS(_uM("--rice-primary-color" to "#1989fa", "--rice-primary-color-1" to "#e6f7ff", "--rice-primary-color-7" to "#0b68d4", "--rice-success-color" to "#07c160", "--rice-success-color-1" to "#e6ffee", "--rice-success-color-7" to "#009c50", "--rice-warning-color" to "#e6a23c", "--rice-warning-color-1" to "#fffbe8", "--rice-warning-color-7" to "#bf7e28", "--rice-error-color" to "#f56c6c", "--rice-error-color-1" to "#fff2f0", "--rice-error-color-7" to "#cf5155", "--rice-text-color" to "#323233", "--rice-text-color-2" to "#969799", "--rice-text-color-3" to "#c8c9cc", "--rice-text-color-white" to "#fff", "--rice-border-color" to "#ebedf0", "--rice-background" to "#f7f8fa", "--rice-background-2" to "#fff", "--rice-hover-color" to "#f2f3f5", "--rice-button-default-border" to "#eaecf1", "--rice-button-default-background" to "#fff", "--rice-button-default-hover-background" to "#f1f1f1", "--rice-button-info-background" to "#e1e1e1", "--rice-button-info-hover-background" to "#c1c1c1", "--rice-tag-default-border" to "#dcdfe6", "--rice-divider-line-color" to "#d6d7d9", "--rice-image-placeholder-background" to "#f7f8fa", "--rice-progress-background" to "#ebedf0", "--rice-skeleton-background" to "#f2f3f5", "--rice-checkbox-disabled-background" to "#ebedf0", "--rice-checkbox-disabled-border-color" to "#c8c9cc", "--rice-checkbox-border-color" to "#c8c9cc", "--rice-checkbox-label-disabled-color" to "#c8c9cc", "--rice-radio-disabled-background" to "#ebedf0", "--rice-radio-disabled-border-color" to "#c8c9cc", "--rice-radio-border-color" to "#c8c9cc", "--rice-radio-label-disabled-color" to "#c8c9cc", "--rice-switch-background" to "#dcdcdc", "--rice-stepper-background" to "#f2f3f5", "--rice-input-border-color" to "#dcdfe6", "--rice-input-disabled-background" to "#f5f7fa", "--rice-input-disabled-text-color" to "#c0c4cc", "--rice-textarea-background" to "#fff", "--rice-textarea-border-color" to "#dcdfe6", "--rice-textarea-disabled-background" to "#f5f7fa", "--rice-textarea-disabled-text-color" to "#c0c4cc", "--rice-search-background" to "transparent", "--rice-search-input-background" to "#f7f8fa", "--rice-signature-border-color" to "#dadada", "--rice-signature-background" to "#fff", "--rice-overlay-background" to "rgba(0, 0, 0, .7)", "--rice-action-sheet-background" to "#f3f3f3", "--rice-action-sheet-menu-background" to "#fff", "--rice-action-sheet-hover-background" to "#f2f3f5", "--rice-action-sheet-cancel-text-color" to "#646566", "--rice-action-sheet-menu-disabled-text-color" to "#c8c9cc", "--rice-dialog-message-text-color" to "#969799", "--rice-navbar-background" to "#f5f5f5", "--rice-tabs-disabled-text-color" to "#c8c9cc", "--rice-cell-background" to "#fff", "--rice-collapse-background" to "#fff", "--rice-grid-background" to "#fff", "--rice-picker-background" to "#fff", "--rice-picker-loading-background" to "rgba(255, 255, 255, .8)", "--rice-picker-disabled-text-color" to "rgba(0, 0, 0, .26)", "--rice-back-top-background" to "#fff", "--rice-tabs-background" to "#fff", "--rice-dialog-background" to "#fff", "--rice-slider-inactive-background" to "#dcdcdc", "--rice-rate-color" to "#ee0a24", "--rice-rate-void-color" to "#cdd0d6", "--rice-calendar-background" to "#fff", "--rice-calendar-info-text" to "#969799", "--rice-calendar-disabled-text" to "#c8c9cc", "--rice-cascader-background" to "#fff", "--rice-cascader-disabled-text-color" to "rgba(0, 0, 0, .26)", "--rice-code-input-background" to "#f2f2f2", "--rice-scroll-x-indicator-background" to "#f1f1f1", "--rice-form-error-color" to "#ee0a24", "--rice-form-item-border" to "#e7e7e7", "--rice-uploader-background" to "#f7f8fa")), "rice-theme-dark" to _pS(_uM("--rice-primary-color" to "#1989fa", "--rice-primary-color-1" to "#111c2b", "--rice-primary-color-7" to "#3d98e8", "--rice-success-color" to "#07c160", "--rice-success-color-1" to "#11231b", "--rice-success-color-7" to "#27bc6a", "--rice-warning-color" to "#e6a23c", "--rice-warning-color-1" to "#281f15", "--rice-warning-color-7" to "#dcae5e", "--rice-error-color" to "#f56c6c", "--rice-error-color-1" to "#2a1a1b", "--rice-error-color-7" to "#e88e8c", "--rice-border-color" to "#3a3a3c", "--rice-text-color" to "#f5f5f5", "--rice-text-color-2" to "#707070", "--rice-text-color-3" to "#4d4d4d", "--rice-text-color-white" to "#f5f5f5", "--rice-background" to "#181818", "--rice-background-2" to "#242424", "--rice-hover-color" to "#3a3a3c", "--rice-button-default-border" to "#383838", "--rice-button-default-background" to "#383838", "--rice-button-default-hover-background" to "#4b4b4b", "--rice-button-info-background" to "#2b2b2b", "--rice-button-info-hover-background" to "#3b3b3b", "--rice-tag-default-border" to "#a5a5a5", "--rice-divider-line-color" to "#3a3a3c", "--rice-image-placeholder-background" to "#262727", "--rice-progress-background" to "#363637", "--rice-skeleton-background" to "#3a3a3c", "--rice-checkbox-disabled-background" to "#3a3a3c", "--rice-checkbox-border-color" to "#c8c9cc", "--rice-checkbox-disabled-border-color" to "#c8c9cc", "--rice-checkbox-label-disabled-color" to "#4d4d4d", "--rice-radio-disabled-background" to "#3a3a3c", "--rice-radio-border-color" to "#c8c9cc", "--rice-radio-disabled-border-color" to "#c8c9cc", "--rice-radio-label-disabled-color" to "#4d4d4d", "--rice-switch-background" to "#3a3a3a", "--rice-stepper-background" to "#3a3a3c", "--rice-input-border-color" to "#4c4d4f", "--rice-input-disabled-background" to "#262727", "--rice-input-disabled-text-color" to "#8d9095", "--rice-textarea-background" to "#242424", "--rice-textarea-border-color" to "#4c4d4f", "--rice-textarea-disabled-background" to "#262727", "--rice-textarea-disabled-text-color" to "#8d9095", "--rice-search-input-background" to "#181818", "--rice-search-background" to "transparent", "--rice-signature-background" to "#242424", "--rice-signature-border-color" to "#dadada", "--rice-cell-background" to "#242424", "--rice-collapse-background" to "#242424", "--rice-grid-background" to "#242424", "--rice-overlay-background" to "rgba(0, 0, 0, .6)", "--rice-action-sheet-background" to "#181818", "--rice-action-sheet-menu-background" to "#242424", "--rice-action-sheet-hover-background" to "#3a3a3c", "--rice-action-sheet-cancel-text-color" to "#a6acaf", "--rice-action-sheet-menu-disabled-text-color" to "#4d4d4d", "--rice-dialog-message-text-color" to "rgba(255, 255, 255, .55)", "--rice-navbar-background" to "#181818", "--rice-tabs-disabled-text-color" to "#4d4d4d", "--rice-picker-background" to "#181818", "--rice-picker-loading-background" to "rgba(0, 0, 0, .7)", "--rice-picker-disabled-text-color" to "rgba(255, 255, 255, .35)", "--rice-back-top-background" to "#242424", "--rice-tabs-background" to "#242424", "--rice-dialog-background" to "#242424", "--rice-slider-inactive-background" to "#383838", "--rice-rate-color" to "#ee0a24", "--rice-rate-void-color" to "#636466", "--rice-calendar-background" to "#242424", "--rice-calendar-info-text" to "#cdcbcb", "--rice-calendar-disabled-text" to "#646566", "--rice-cascader-background" to "#242424", "--rice-cascader-disabled-text-color" to "rgba(255, 255, 255, .35)", "--rice-code-input-background" to "#242424", "--rice-scroll-x-indicator-background" to "#262727", "--rice-form-error-color" to "#ee0a24", "--rice-form-item-border" to "#3a3a3c", "--rice-uploader-background" to "#262727")), "rice-variables" to _pS(_uM("--rice-black" to "#000", "--rice-white" to "#fff", "--rice-padding-base" to "4px", "--rice-padding-xs" to "8px", "--rice-padding-sm" to "12px", "--rice-padding-md" to "16px", "--rice-padding-lg" to "24px", "--rice-font-size-mi" to "10px", "--rice-font-size-xs" to "12px", "--rice-font-size-sm" to "14px", "--rice-font-size-basic" to "15px", "--rice-font-size-md" to "16px", "--rice-font-size-lg" to "18px", "--rice-radius-xs" to "2px", "--rice-radius-sm" to "4px", "--rice-radius-md" to "8px", "--rice-radius-lg" to "12px")), "uni-row" to _pS(_uM("flexDirection" to "row")), "uni-column" to _pS(_uM("flexDirection" to "column")))
            }
    }
}
val GenAppClass = CreateVueAppComponent(GenApp::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "app", name = "", inheritAttrs = true, inject = Map(), props = Map(), propsNeedCastKeys = _uA(), emits = Map(), components = Map(), styles = GenApp.styles)
}
, fun(instance): GenApp {
    return GenApp(instance)
}
)
val GenUniModulesRiceUiComponentsRiceIconRiceIconClass = CreateVueComponent(GenUniModulesRiceUiComponentsRiceIconRiceIcon::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesRiceUiComponentsRiceIconRiceIcon.name, inheritAttrs = GenUniModulesRiceUiComponentsRiceIconRiceIcon.inheritAttrs, inject = GenUniModulesRiceUiComponentsRiceIconRiceIcon.inject, props = GenUniModulesRiceUiComponentsRiceIconRiceIcon.props, propsNeedCastKeys = GenUniModulesRiceUiComponentsRiceIconRiceIcon.propsNeedCastKeys, emits = GenUniModulesRiceUiComponentsRiceIconRiceIcon.emits, components = GenUniModulesRiceUiComponentsRiceIconRiceIcon.components, styles = GenUniModulesRiceUiComponentsRiceIconRiceIcon.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesRiceUiComponentsRiceIconRiceIcon.setup(props as GenUniModulesRiceUiComponentsRiceIconRiceIcon)
    }
    )
}
, fun(instance, renderer): GenUniModulesRiceUiComponentsRiceIconRiceIcon {
    return GenUniModulesRiceUiComponentsRiceIconRiceIcon(instance)
}
)
val GenUniModulesRiceUiComponentsRiceNavbarRiceNavbarClass = CreateVueComponent(GenUniModulesRiceUiComponentsRiceNavbarRiceNavbar::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesRiceUiComponentsRiceNavbarRiceNavbar.name, inheritAttrs = GenUniModulesRiceUiComponentsRiceNavbarRiceNavbar.inheritAttrs, inject = GenUniModulesRiceUiComponentsRiceNavbarRiceNavbar.inject, props = GenUniModulesRiceUiComponentsRiceNavbarRiceNavbar.props, propsNeedCastKeys = GenUniModulesRiceUiComponentsRiceNavbarRiceNavbar.propsNeedCastKeys, emits = GenUniModulesRiceUiComponentsRiceNavbarRiceNavbar.emits, components = GenUniModulesRiceUiComponentsRiceNavbarRiceNavbar.components, styles = GenUniModulesRiceUiComponentsRiceNavbarRiceNavbar.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesRiceUiComponentsRiceNavbarRiceNavbar.setup(props as GenUniModulesRiceUiComponentsRiceNavbarRiceNavbar)
    }
    )
}
, fun(instance, renderer): GenUniModulesRiceUiComponentsRiceNavbarRiceNavbar {
    return GenUniModulesRiceUiComponentsRiceNavbarRiceNavbar(instance)
}
)
val GenPagesBookcaseIndexClass = CreateVueComponent(GenPagesBookcaseIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesBookcaseIndex.inheritAttrs, inject = GenPagesBookcaseIndex.inject, props = GenPagesBookcaseIndex.props, propsNeedCastKeys = GenPagesBookcaseIndex.propsNeedCastKeys, emits = GenPagesBookcaseIndex.emits, components = GenPagesBookcaseIndex.components, styles = GenPagesBookcaseIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesBookcaseIndex.setup(props as GenPagesBookcaseIndex)
    }
    )
}
, fun(instance, renderer): GenPagesBookcaseIndex {
    return GenPagesBookcaseIndex(instance, renderer)
}
)
val GenPagesLibraryIndexClass = CreateVueComponent(GenPagesLibraryIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesLibraryIndex.inheritAttrs, inject = GenPagesLibraryIndex.inject, props = GenPagesLibraryIndex.props, propsNeedCastKeys = GenPagesLibraryIndex.propsNeedCastKeys, emits = GenPagesLibraryIndex.emits, components = GenPagesLibraryIndex.components, styles = GenPagesLibraryIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesLibraryIndex.setup(props as GenPagesLibraryIndex)
    }
    )
}
, fun(instance, renderer): GenPagesLibraryIndex {
    return GenPagesLibraryIndex(instance, renderer)
}
)
val GenPagesDiscussIndexClass = CreateVueComponent(GenPagesDiscussIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesDiscussIndex.inheritAttrs, inject = GenPagesDiscussIndex.inject, props = GenPagesDiscussIndex.props, propsNeedCastKeys = GenPagesDiscussIndex.propsNeedCastKeys, emits = GenPagesDiscussIndex.emits, components = GenPagesDiscussIndex.components, styles = GenPagesDiscussIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesDiscussIndex.setup(props as GenPagesDiscussIndex)
    }
    )
}
, fun(instance, renderer): GenPagesDiscussIndex {
    return GenPagesDiscussIndex(instance, renderer)
}
)
val GenUniModulesRiceUiComponentsRiceAvatarRiceAvatarClass = CreateVueComponent(GenUniModulesRiceUiComponentsRiceAvatarRiceAvatar::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesRiceUiComponentsRiceAvatarRiceAvatar.name, inheritAttrs = GenUniModulesRiceUiComponentsRiceAvatarRiceAvatar.inheritAttrs, inject = GenUniModulesRiceUiComponentsRiceAvatarRiceAvatar.inject, props = GenUniModulesRiceUiComponentsRiceAvatarRiceAvatar.props, propsNeedCastKeys = GenUniModulesRiceUiComponentsRiceAvatarRiceAvatar.propsNeedCastKeys, emits = GenUniModulesRiceUiComponentsRiceAvatarRiceAvatar.emits, components = GenUniModulesRiceUiComponentsRiceAvatarRiceAvatar.components, styles = GenUniModulesRiceUiComponentsRiceAvatarRiceAvatar.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesRiceUiComponentsRiceAvatarRiceAvatar.setup(props as GenUniModulesRiceUiComponentsRiceAvatarRiceAvatar)
    }
    )
}
, fun(instance, renderer): GenUniModulesRiceUiComponentsRiceAvatarRiceAvatar {
    return GenUniModulesRiceUiComponentsRiceAvatarRiceAvatar(instance)
}
)
val GenUniModulesRiceUiComponentsRiceCellRiceCellClass = CreateVueComponent(GenUniModulesRiceUiComponentsRiceCellRiceCell::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesRiceUiComponentsRiceCellRiceCell.name, inheritAttrs = GenUniModulesRiceUiComponentsRiceCellRiceCell.inheritAttrs, inject = GenUniModulesRiceUiComponentsRiceCellRiceCell.inject, props = GenUniModulesRiceUiComponentsRiceCellRiceCell.props, propsNeedCastKeys = GenUniModulesRiceUiComponentsRiceCellRiceCell.propsNeedCastKeys, emits = GenUniModulesRiceUiComponentsRiceCellRiceCell.emits, components = GenUniModulesRiceUiComponentsRiceCellRiceCell.components, styles = GenUniModulesRiceUiComponentsRiceCellRiceCell.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesRiceUiComponentsRiceCellRiceCell.setup(props as GenUniModulesRiceUiComponentsRiceCellRiceCell)
    }
    )
}
, fun(instance, renderer): GenUniModulesRiceUiComponentsRiceCellRiceCell {
    return GenUniModulesRiceUiComponentsRiceCellRiceCell(instance)
}
)
val GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroupClass = CreateVueComponent(GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroup::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroup.name, inheritAttrs = GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroup.inheritAttrs, inject = GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroup.inject, props = GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroup.props, propsNeedCastKeys = GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroup.propsNeedCastKeys, emits = GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroup.emits, components = GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroup.components, styles = GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroup.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroup.setup(props as GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroup)
    }
    )
}
, fun(instance, renderer): GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroup {
    return GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroup(instance)
}
)
val GenUniModulesRiceUiComponentsRiceOverlayRiceOverlayClass = CreateVueComponent(GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay.name, inheritAttrs = GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay.inheritAttrs, inject = GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay.inject, props = GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay.props, propsNeedCastKeys = GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay.propsNeedCastKeys, emits = GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay.emits, components = GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay.components, styles = GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay.setup(props as GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay)
    }
    )
}
, fun(instance, renderer): GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay {
    return GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay(instance)
}
)
open class UseLoadingOptions (
    @JsonNotNull
    open var loadingRef: Ref<UniElement?>,
    @JsonNotNull
    open var coreRef: Ref<UniElement?>,
    @JsonNotNull
    open var circularRef: Ref<UniElement?>,
    @JsonNotNull
    open var mode: LoadingMode,
    @JsonNotNull
    open var timingFunction: LoadingTimingFunction,
    @JsonNotNull
    open var color: ComputedRef<String>,
    @JsonNotNull
    open var size: Ref<Any>,
    @JsonNotNull
    open var duration: Number,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("UseLoadingOptions", "uni_modules/rice-ui/components/rice-loading/use-loading.uts", 3, 13)
    }
}
val easeInOutCubic = fun(t: Number): Number {
    return if (t < 0.5) {
        4 * t * t * t
    } else {
        (t - 1) * (2 * t - 2) * (2 * t - 2) + 1
    }
}
fun useLoading(options: UseLoadingOptions) {
    var timer: Number? = null
    var drawContext: DrawableContext? = null
    val startAmination = fun(): UTSPromise<Unit> {
        return wrapUTSPromise(suspend w1@{
                val coreRef = options.coreRef
                val timingFunction = options.timingFunction
                await(nextTick())
                if (coreRef.value == null) {
                    return@w1
                }
                coreRef.value!!.animate(_uA(
                    UniAnimationKeyframe(transform = "rotate(0deg)"),
                    UniAnimationKeyframe(transform = "rotate(360deg)")
                ), UniAnimationOption(duration = options.duration, easing = timingFunction, iterations = Infinity))
        })
    }
    val drawCircular = fun(ctx: DrawableContext){
        var rotate: Number = 0
        val size = getPxNum(options.size.value)
        val ARC_LENGTH: Number = 359
        val center = size / 2
        val lineWidth = size / 10
        val duration = options.duration
        val ARC_MAX: Number = 352
        var startTime: Number = 0
        var foreward_end: Number = 0
        var reversal_end = ARC_MAX
        fun pogressTime(): Number {
            val currentTime = Date.now()
            val elapsedTime = currentTime - startTime
            val progress = elapsedTime / duration
            val easedProgress = easeInOutCubic(progress)
            return easedProgress
        }
        val draw = fun(){
            ctx.reset()
            ctx.beginPath()
            if (reversal_end == ARC_MAX) {
                foreward_end = Math.min(pogressTime() * ARC_LENGTH, ARC_LENGTH)
                if (foreward_end >= ARC_MAX) {
                    reversal_end = 0
                    foreward_end = ARC_MAX
                    startTime = Date.now()
                }
            }
            if (foreward_end == ARC_MAX) {
                reversal_end = Math.min(pogressTime() * ARC_LENGTH, ARC_LENGTH)
                if (reversal_end >= ARC_MAX) {
                    reversal_end = ARC_MAX
                    foreward_end = 0
                    startTime = Date.now()
                }
            }
            ctx.arc(center, center, center - lineWidth, rotate + (reversal_end * Math.PI / 180), rotate + (foreward_end * Math.PI / 180))
            ctx.lineWidth = lineWidth
            ctx.strokeStyle = options.color.value
            ctx.stroke()
            ctx.update()
            rotate += 0.05
        }
        timer = setInterval(fun(){
            return draw()
        }
        , 16)
    }
    val removeInterval = fun(){
        if (timer != null) {
            clearInterval(timer!!)
            timer = null
        }
    }
    val initCircular = fun(){
        val circularRef = options.circularRef
        if (circularRef.value == null) {
            return
        }
        removeInterval()
        drawContext = circularRef.value!!.getDrawableContext()!!
        drawContext!!.reset()
        drawCircular(drawContext!!)
    }
    val init = fun(): UTSPromise<Unit> {
        return wrapUTSPromise(suspend {
                await(nextTick())
                initCircular()
                startAmination()
        })
    }
    watch(_uA(
        fun(): String {
            return options.color.value
        }
        ,
        fun(): Any {
            return options.size.value
        }
    ), fun(){
        initCircular()
    }
    )
    onMounted(fun(){
        init()
    }
    )
    onUnmounted(fun(){
        removeInterval()
    }
    )
    var hasHide = false
    onPageShow(fun(){
        if (hasHide && drawContext != null) {
            drawCircular(drawContext!!)
        }
    }
    )
    onPageHide(fun(){
        hasHide = true
        removeInterval()
    }
    )
}
val GenUniModulesRiceUiComponentsRiceLoadingRiceLoadingClass = CreateVueComponent(GenUniModulesRiceUiComponentsRiceLoadingRiceLoading::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesRiceUiComponentsRiceLoadingRiceLoading.name, inheritAttrs = GenUniModulesRiceUiComponentsRiceLoadingRiceLoading.inheritAttrs, inject = GenUniModulesRiceUiComponentsRiceLoadingRiceLoading.inject, props = GenUniModulesRiceUiComponentsRiceLoadingRiceLoading.props, propsNeedCastKeys = GenUniModulesRiceUiComponentsRiceLoadingRiceLoading.propsNeedCastKeys, emits = GenUniModulesRiceUiComponentsRiceLoadingRiceLoading.emits, components = GenUniModulesRiceUiComponentsRiceLoadingRiceLoading.components, styles = GenUniModulesRiceUiComponentsRiceLoadingRiceLoading.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesRiceUiComponentsRiceLoadingRiceLoading.setup(props as GenUniModulesRiceUiComponentsRiceLoadingRiceLoading)
    }
    )
}
, fun(instance, renderer): GenUniModulesRiceUiComponentsRiceLoadingRiceLoading {
    return GenUniModulesRiceUiComponentsRiceLoadingRiceLoading(instance)
}
)
val iconSizeTypes: UTSJSONObject = object : UTSJSONObject(UTSSourceMapPosition("iconSizeTypes", "uni_modules/rice-ui/components/rice-button/utils.uts", 1, 14)) {
    var large = "18px"
    var `default` = "16px"
    var small = "14px"
    var mini = "12px"
}
val loadingSizeTypes: UTSJSONObject = object : UTSJSONObject(UTSSourceMapPosition("loadingSizeTypes", "uni_modules/rice-ui/components/rice-button/utils.uts", 7, 14)) {
    var large = "20px"
    var `default` = "18px"
    var small = "16px"
    var mini = "14px"
}
val GenUniModulesRiceUiComponentsRiceButtonRiceButtonClass = CreateVueComponent(GenUniModulesRiceUiComponentsRiceButtonRiceButton::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesRiceUiComponentsRiceButtonRiceButton.name, inheritAttrs = GenUniModulesRiceUiComponentsRiceButtonRiceButton.inheritAttrs, inject = GenUniModulesRiceUiComponentsRiceButtonRiceButton.inject, props = GenUniModulesRiceUiComponentsRiceButtonRiceButton.props, propsNeedCastKeys = GenUniModulesRiceUiComponentsRiceButtonRiceButton.propsNeedCastKeys, emits = GenUniModulesRiceUiComponentsRiceButtonRiceButton.emits, components = GenUniModulesRiceUiComponentsRiceButtonRiceButton.components, styles = GenUniModulesRiceUiComponentsRiceButtonRiceButton.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesRiceUiComponentsRiceButtonRiceButton.setup(props as GenUniModulesRiceUiComponentsRiceButtonRiceButton)
    }
    )
}
, fun(instance, renderer): GenUniModulesRiceUiComponentsRiceButtonRiceButton {
    return GenUniModulesRiceUiComponentsRiceButtonRiceButton(instance)
}
)
val GenUniModulesRiceUiComponentsRiceDialogRiceDialogClass = CreateVueComponent(GenUniModulesRiceUiComponentsRiceDialogRiceDialog::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesRiceUiComponentsRiceDialogRiceDialog.name, inheritAttrs = GenUniModulesRiceUiComponentsRiceDialogRiceDialog.inheritAttrs, inject = GenUniModulesRiceUiComponentsRiceDialogRiceDialog.inject, props = GenUniModulesRiceUiComponentsRiceDialogRiceDialog.props, propsNeedCastKeys = GenUniModulesRiceUiComponentsRiceDialogRiceDialog.propsNeedCastKeys, emits = GenUniModulesRiceUiComponentsRiceDialogRiceDialog.emits, components = GenUniModulesRiceUiComponentsRiceDialogRiceDialog.components, styles = GenUniModulesRiceUiComponentsRiceDialogRiceDialog.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesRiceUiComponentsRiceDialogRiceDialog.setup(props as GenUniModulesRiceUiComponentsRiceDialogRiceDialog)
    }
    )
}
, fun(instance, renderer): GenUniModulesRiceUiComponentsRiceDialogRiceDialog {
    return GenUniModulesRiceUiComponentsRiceDialogRiceDialog(instance)
}
)
val GenPagesMineIndexClass = CreateVueComponent(GenPagesMineIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesMineIndex.inheritAttrs, inject = GenPagesMineIndex.inject, props = GenPagesMineIndex.props, propsNeedCastKeys = GenPagesMineIndex.propsNeedCastKeys, emits = GenPagesMineIndex.emits, components = GenPagesMineIndex.components, styles = GenPagesMineIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesMineIndex.setup(props as GenPagesMineIndex)
    }
    )
}
, fun(instance, renderer): GenPagesMineIndex {
    return GenPagesMineIndex(instance, renderer)
}
)
val GenUniModulesRiceUiComponentsRiceSearchRiceSearchClass = CreateVueComponent(GenUniModulesRiceUiComponentsRiceSearchRiceSearch::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesRiceUiComponentsRiceSearchRiceSearch.name, inheritAttrs = GenUniModulesRiceUiComponentsRiceSearchRiceSearch.inheritAttrs, inject = GenUniModulesRiceUiComponentsRiceSearchRiceSearch.inject, props = GenUniModulesRiceUiComponentsRiceSearchRiceSearch.props, propsNeedCastKeys = GenUniModulesRiceUiComponentsRiceSearchRiceSearch.propsNeedCastKeys, emits = GenUniModulesRiceUiComponentsRiceSearchRiceSearch.emits, components = GenUniModulesRiceUiComponentsRiceSearchRiceSearch.components, styles = GenUniModulesRiceUiComponentsRiceSearchRiceSearch.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesRiceUiComponentsRiceSearchRiceSearch.setup(props as GenUniModulesRiceUiComponentsRiceSearchRiceSearch)
    }
    )
}
, fun(instance, renderer): GenUniModulesRiceUiComponentsRiceSearchRiceSearch {
    return GenUniModulesRiceUiComponentsRiceSearchRiceSearch(instance)
}
)
val GenPagesSearchIndexClass = CreateVueComponent(GenPagesSearchIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesSearchIndex.inheritAttrs, inject = GenPagesSearchIndex.inject, props = GenPagesSearchIndex.props, propsNeedCastKeys = GenPagesSearchIndex.propsNeedCastKeys, emits = GenPagesSearchIndex.emits, components = GenPagesSearchIndex.components, styles = GenPagesSearchIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesSearchIndex.setup(props as GenPagesSearchIndex)
    }
    )
}
, fun(instance, renderer): GenPagesSearchIndex {
    return GenPagesSearchIndex(instance, renderer)
}
)
val GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheetClass = CreateVueComponent(GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet.name, inheritAttrs = GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet.inheritAttrs, inject = GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet.inject, props = GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet.props, propsNeedCastKeys = GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet.propsNeedCastKeys, emits = GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet.emits, components = GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet.components, styles = GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet.setup(props as GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet)
    }
    )
}
, fun(instance, renderer): GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet {
    return GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet(instance)
}
)
val GenUniModulesRiceUiPagesActionSheetActionSheetClass = CreateVueComponent(GenUniModulesRiceUiPagesActionSheetActionSheet::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = GenUniModulesRiceUiPagesActionSheetActionSheet.name, inheritAttrs = GenUniModulesRiceUiPagesActionSheetActionSheet.inheritAttrs, inject = GenUniModulesRiceUiPagesActionSheetActionSheet.inject, props = GenUniModulesRiceUiPagesActionSheetActionSheet.props, propsNeedCastKeys = GenUniModulesRiceUiPagesActionSheetActionSheet.propsNeedCastKeys, emits = GenUniModulesRiceUiPagesActionSheetActionSheet.emits, components = GenUniModulesRiceUiPagesActionSheetActionSheet.components, styles = GenUniModulesRiceUiPagesActionSheetActionSheet.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenUniModulesRiceUiPagesActionSheetActionSheet.setup(props as GenUniModulesRiceUiPagesActionSheetActionSheet, ctx)
    }
    )
}
, fun(instance, renderer): GenUniModulesRiceUiPagesActionSheetActionSheet {
    return GenUniModulesRiceUiPagesActionSheetActionSheet(instance, renderer)
}
)
val GenUniModulesRiceUiPagesDialogDialogClass = CreateVueComponent(GenUniModulesRiceUiPagesDialogDialog::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = GenUniModulesRiceUiPagesDialogDialog.name, inheritAttrs = GenUniModulesRiceUiPagesDialogDialog.inheritAttrs, inject = GenUniModulesRiceUiPagesDialogDialog.inject, props = GenUniModulesRiceUiPagesDialogDialog.props, propsNeedCastKeys = GenUniModulesRiceUiPagesDialogDialog.propsNeedCastKeys, emits = GenUniModulesRiceUiPagesDialogDialog.emits, components = GenUniModulesRiceUiPagesDialogDialog.components, styles = GenUniModulesRiceUiPagesDialogDialog.styles, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenUniModulesRiceUiPagesDialogDialog.setup(props as GenUniModulesRiceUiPagesDialogDialog, ctx)
    }
    )
}
, fun(instance, renderer): GenUniModulesRiceUiPagesDialogDialog {
    return GenUniModulesRiceUiPagesDialogDialog(instance, renderer)
}
)
fun createApp(): UTSJSONObject {
    val app = createSSRApp(GenAppClass)
    return _uO("app" to app)
}
fun main(app: IApp) {
    definePageRoutes()
    defineAppConfig()
    (createApp()["app"] as VueApp).mount(app, GenUniApp())
}
open class UniAppConfig : io.dcloud.uniapp.appframe.AppConfig {
    override var name: String = "看小说"
    override var appid: String = "__UNI__4CF4B90"
    override var versionName: String = "1.0.0"
    override var versionCode: String = "100"
    override var uniCompilerVersion: String = "4.87"
    constructor() : super() {}
}
fun definePageRoutes() {
    __uniRoutes.push(UniPageRoute(path = "pages/bookcase/index", component = GenPagesBookcaseIndexClass, meta = UniPageMeta(isQuit = true), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/library/index", component = GenPagesLibraryIndexClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/discuss/index", component = GenPagesDiscussIndexClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/mine/index", component = GenPagesMineIndexClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/search/index", component = GenPagesSearchIndexClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "uni_modules/rice-ui/pages/action-sheet/action-sheet", component = GenUniModulesRiceUiPagesActionSheetActionSheetClass, meta = UniPageMeta(isQuit = false), style = _uM()))
    __uniRoutes.push(UniPageRoute(path = "uni_modules/rice-ui/pages/dialog/dialog", component = GenUniModulesRiceUiPagesDialogDialogClass, meta = UniPageMeta(isQuit = false), style = _uM()))
}
val __uniTabBar: Map<String, Any?>? = _uM("color" to "@tabBarColor", "selectedColor" to "@tabBarSelectedColor", "borderStyle" to "@tabBarBorderStyle", "backgroundColor" to "@tabBarBackgroundColor", "list" to _uA(
    _uM("pagePath" to "pages/bookcase/index", "iconPath" to "@tabBarIconPath1", "selectedIconPath" to "@tabBarSelectedIconPath1", "text" to "书架"),
    _uM("pagePath" to "pages/library/index", "iconPath" to "@tabBarIconPath2", "selectedIconPath" to "@tabBarSelectedIconPath2", "text" to "书库"),
    _uM("pagePath" to "pages/discuss/index", "iconPath" to "@tabBarIconPath3", "selectedIconPath" to "@tabBarSelectedIconPath3", "text" to "讨论"),
    _uM("pagePath" to "pages/mine/index", "iconPath" to "@tabBarIconPath4", "selectedIconPath" to "@tabBarSelectedIconPath4", "text" to "我的")
))
val __uniLaunchPage: Map<String, Any?> = _uM("url" to "pages/bookcase/index", "style" to _uM("navigationBarTitleText" to ""))
fun defineAppConfig() {
    __uniConfig.entryPagePath = "/pages/bookcase/index"
    __uniConfig.globalStyle = _uM("backgroundColorContent" to "@globalStyleBackgroundColor", "navigationStyle" to "custom")
    __uniConfig.getTabBarConfig = fun(): Map<String, Any>? {
        return _uM("color" to "@tabBarColor", "selectedColor" to "@tabBarSelectedColor", "borderStyle" to "@tabBarBorderStyle", "backgroundColor" to "@tabBarBackgroundColor", "list" to _uA(
            _uM("pagePath" to "pages/bookcase/index", "iconPath" to "@tabBarIconPath1", "selectedIconPath" to "@tabBarSelectedIconPath1", "text" to "书架"),
            _uM("pagePath" to "pages/library/index", "iconPath" to "@tabBarIconPath2", "selectedIconPath" to "@tabBarSelectedIconPath2", "text" to "书库"),
            _uM("pagePath" to "pages/discuss/index", "iconPath" to "@tabBarIconPath3", "selectedIconPath" to "@tabBarSelectedIconPath3", "text" to "讨论"),
            _uM("pagePath" to "pages/mine/index", "iconPath" to "@tabBarIconPath4", "selectedIconPath" to "@tabBarSelectedIconPath4", "text" to "我的")
        ))
    }
    __uniConfig.tabBar = __uniConfig.getTabBarConfig()
    __uniConfig.conditionUrl = ""
    __uniConfig.uniIdRouter = _uM()
    __uniConfig.themeConfig = _uM("light" to _uM("tabBarColor" to "#2c2c2c", "tabBarSelectedColor" to "#d81e06", "tabBarBorderStyle" to "black", "tabBarBackgroundColor" to "#f5f5f5", "tabBarIconPath1" to "static/image/wap-home-o.png", "tabBarSelectedIconPath1" to "static/image/wap-home.png", "tabBarIconPath2" to "static/image/browsing-history-o.png", "tabBarSelectedIconPath2" to "static/image/browsing-history.png", "tabBarIconPath3" to "static/image/comment-o.png", "tabBarSelectedIconPath3" to "static/image/comment.png", "tabBarIconPath4" to "static/image/manager-o.png", "tabBarSelectedIconPath4" to "static/image/manager.png", "globalStyleBackgroundColor" to "#f5f5f5"), "dark" to _uM("tabBarColor" to "#e6e6e6", "tabBarSelectedColor" to "#d81e06", "tabBarBorderStyle" to "white", "tabBarBackgroundColor" to "#181818", "tabBarIconPath1" to "static/image/wap-home-w.png", "tabBarSelectedIconPath1" to "static/image/wap-home.png", "tabBarIconPath2" to "static/image/browsing-history-w.png", "tabBarSelectedIconPath2" to "static/image/browsing-history.png", "tabBarIconPath3" to "static/image/comment-w.png", "tabBarSelectedIconPath3" to "static/image/comment.png", "tabBarIconPath4" to "static/image/manager-w.png", "tabBarSelectedIconPath4" to "static/image/manager.png", "globalStyleBackgroundColor" to "#181818"))
    __uniConfig.ready = true
}
open class GenUniApp : UniAppImpl() {
    open val vm: GenApp?
        get() {
            return getAppVm() as GenApp?
        }
    open val `$vm`: GenApp?
        get() {
            return getAppVm() as GenApp?
        }
}
fun getApp(): GenUniApp {
    return getUniApp() as GenUniApp
}
