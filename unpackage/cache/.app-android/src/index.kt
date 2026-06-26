@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI194B5B1
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
import io.dcloud.uniapp.extapi.getAppBaseInfo as uni_getAppBaseInfo
import io.dcloud.uniapp.extapi.getDeviceInfo as uni_getDeviceInfo
import io.dcloud.uniapp.extapi.getFileSystemManager as uni_getFileSystemManager
import io.dcloud.uniapp.extapi.getStorageSync as uni_getStorageSync
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import io.dcloud.uniapp.extapi.offKeyboardHeightChange as uni_offKeyboardHeightChange
import io.dcloud.uniapp.extapi.onKeyboardHeightChange as uni_onKeyboardHeightChange
import io.dcloud.uniapp.extapi.openDialogPage as uni_openDialogPage
import io.dcloud.uniapp.extapi.rpx2px as uni_rpx2px
import io.dcloud.uniapp.extapi.setAppTheme as uni_setAppTheme
import io.dcloud.uniapp.extapi.setStorageSync as uni_setStorageSync
import io.dcloud.uniapp.extapi.showToast as uni_showToast
val runBlock1 = run {
    __uniConfig.getAppStyles = fun(): Map<String, Map<String, Map<String, Any>>> {
        return GenApp.styles
    }
}
typealias currentPageCaptureScreenshotCallBack = (base64: String, error: String) -> Unit
fun currentPageCaptureScreenshot(fullPage: Boolean, callback: currentPageCaptureScreenshotCallBack) {
    val pages = getCurrentPages() as UTSArray<UniPage>
    val currentPage = pages[pages.length - 1]
    currentPage.vm?.`$viewToTempFilePath`(ViewToTempFilePathOptions(wholeContent = fullPage, overwrite = true, success = fun(res){
        val fileManager = uni_getFileSystemManager()
        fileManager.readFile(ReadFileOptions(encoding = "base64", filePath = res.tempFilePath, success = fun(readFileRes) {
            callback(readFileRes.data as String, "")
        }
        , fail = fun(err) {
            callback("", "captureScreenshot fail: " + JSON.stringify(err))
        }
        ))
    }
    , fail = fun(err){
        callback("", "captureScreenshot fail: " + JSON.stringify(err))
    }
    ))
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
        socket.onMessage(fun(result){
            if (UTSAndroid.`typeof`(result["data"]) == "string") {
                val message = UTSAndroid.consoleDebugError(JSON.parse<UTSJSONObject>(result["data"] as String), " at ../../../../../../../../Install/HBuilderX/plugins/uniapp-cli-vite/node_modules/@dcloudio/uni-console/src/runtime/app/socket.ts:67")!!
                if ((message["type"] as String) == "screencap") {
                    val id = message["id"] as String
                    currentPageCaptureScreenshot(message["fullPage"] as Boolean, fun(base64: String, error: String){
                        socket.send(SendSocketMessageOptions(data = JSON.stringify(_uO("id" to id, "base64" to base64, "error" to error))))
                    }
                    )
                }
            }
            resolve(null)
        }
        )
    }
    )
}
fun initRuntimeSocketService(): UTSPromise<Boolean> {
    val hosts: String = "10.191.92.87,127.0.0.1"
    val port: String = "8090"
    val id: String = "app-android_MvAdrY"
    if (hosts == "" || port == "" || id == "") {
        return UTSPromise.resolve(false)
    }
    return UTSPromise.resolve().then(fun(): UTSPromise<Boolean> {
        return initRuntimeSocket(hosts, port, id).then(fun(socket): Boolean {
            if (socket == null) {
                return false
            }
            socket
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
open class UserInfo (
    @JsonNotNull
    open var nickName: String,
    open var avatarUrl: String? = null,
) : UTSReactiveObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("UserInfo", "store/index.uts", 1, 13)
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
    open var navbarHeight: Number,
    @JsonNotNull
    open var safeAreaInsetsHeight: Number,
    @JsonNotNull
    open var keyboardHeight: Number,
    @JsonNotNull
    open var uniPlatform: String,
    @JsonNotNull
    open var devicePixelRatio: Number,
    @JsonNotNull
    open var active: String,
    @JsonNotNull
    open var leftWinActive: String,
    open var agreeToPrivacy: Boolean? = null,
    @JsonNotNull
    open var isFollowSystem: Boolean = false,
    @JsonNotNull
    open var appTheme: String,
    @JsonNotNull
    open var osTheme: String,
    @JsonNotNull
    open var unit: String,
    @JsonNotNull
    open var netless: Boolean = false,
    open var userInfo: UserInfo? = null,
) : UTSReactiveObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("State", "store/index.uts", 16, 6)
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
    constructor(__v_raw: State, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(statusBarHeight = __v_raw.statusBarHeight, navbarHeight = __v_raw.navbarHeight, safeAreaInsetsHeight = __v_raw.safeAreaInsetsHeight, keyboardHeight = __v_raw.keyboardHeight, uniPlatform = __v_raw.uniPlatform, devicePixelRatio = __v_raw.devicePixelRatio, active = __v_raw.active, leftWinActive = __v_raw.leftWinActive, agreeToPrivacy = __v_raw.agreeToPrivacy, isFollowSystem = __v_raw.isFollowSystem, appTheme = __v_raw.appTheme, osTheme = __v_raw.osTheme, unit = __v_raw.unit, netless = __v_raw.netless, userInfo = __v_raw.userInfo) {
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
    override var navbarHeight: Number
        get() {
            return _tRG(__v_raw, "navbarHeight", __v_raw.navbarHeight, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("navbarHeight")) {
                return
            }
            val oldValue = __v_raw.navbarHeight
            __v_raw.navbarHeight = value
            _tRS(__v_raw, "navbarHeight", oldValue, value)
        }
    override var safeAreaInsetsHeight: Number
        get() {
            return _tRG(__v_raw, "safeAreaInsetsHeight", __v_raw.safeAreaInsetsHeight, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("safeAreaInsetsHeight")) {
                return
            }
            val oldValue = __v_raw.safeAreaInsetsHeight
            __v_raw.safeAreaInsetsHeight = value
            _tRS(__v_raw, "safeAreaInsetsHeight", oldValue, value)
        }
    override var keyboardHeight: Number
        get() {
            return _tRG(__v_raw, "keyboardHeight", __v_raw.keyboardHeight, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("keyboardHeight")) {
                return
            }
            val oldValue = __v_raw.keyboardHeight
            __v_raw.keyboardHeight = value
            _tRS(__v_raw, "keyboardHeight", oldValue, value)
        }
    override var uniPlatform: String
        get() {
            return _tRG(__v_raw, "uniPlatform", __v_raw.uniPlatform, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("uniPlatform")) {
                return
            }
            val oldValue = __v_raw.uniPlatform
            __v_raw.uniPlatform = value
            _tRS(__v_raw, "uniPlatform", oldValue, value)
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
    override var isFollowSystem: Boolean
        get() {
            return _tRG(__v_raw, "isFollowSystem", __v_raw.isFollowSystem, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("isFollowSystem")) {
                return
            }
            val oldValue = __v_raw.isFollowSystem
            __v_raw.isFollowSystem = value
            _tRS(__v_raw, "isFollowSystem", oldValue, value)
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
    override var osTheme: String
        get() {
            return _tRG(__v_raw, "osTheme", __v_raw.osTheme, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("osTheme")) {
                return
            }
            val oldValue = __v_raw.osTheme
            __v_raw.osTheme = value
            _tRS(__v_raw, "osTheme", oldValue, value)
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
val state = reactive(State(statusBarHeight = 0, navbarHeight = 44, safeAreaInsetsHeight = 0, keyboardHeight = 0, uniPlatform = "", devicePixelRatio = 1, active = "componentPage", leftWinActive = "/pages/bookcase/index", appTheme = "light", osTheme = "light", unit = "px", isFollowSystem = false, netless = false, userInfo = null, agreeToPrivacy = null))
val setAppTheme = fun(value: String){
    state.appTheme = value
    uni_setStorageSync("appTheme", value)
}
val setIsFollowSystem = fun(value: Boolean){
    state.isFollowSystem = value
    uni_setStorageSync("isFollowSystem", value)
}
val checkWindowInfo = fun(){
    val windowInfo = uni_getWindowInfo()
    state.statusBarHeight = windowInfo.statusBarHeight
    state.safeAreaInsetsHeight = windowInfo.safeAreaInsets.bottom
}
val checkSystemInfo = fun(){
    val appBaseInfo: GetAppBaseInfoResult = uni_getAppBaseInfo(null)
    val deviceInfo: GetDeviceInfoResult = uni_getDeviceInfo(null)
    state.uniPlatform = appBaseInfo.uniPlatform ?: ""
    if (appBaseInfo.uniPlatform === "app") {
        try {
            val isFollowSystem = if (uni_getStorageSync("isFollowSystem") === "") {
                false
            } else {
                (uni_getStorageSync("isFollowSystem") as Boolean)
            }
            state.isFollowSystem = isFollowSystem
            if (isFollowSystem) {
                val osTheme = deviceInfo.osTheme as String
                state.osTheme = osTheme
                setAppTheme(osTheme)
                uni_setAppTheme(SetAppThemeOptions(theme = osTheme))
                uni_setStorageSync("osTheme", osTheme)
            } else {
                var appTheme = uni_getStorageSync("appTheme") as String
                appTheme = if (appTheme == "dark") {
                    "dark"
                } else {
                    "light"
                }
                setAppTheme(appTheme)
                uni_setAppTheme(SetAppThemeOptions(theme = appTheme))
            }
        }
         catch (e: Throwable) {
            console.log("" + e + " 失败", " at store/index.uts:127")
        }
    }
}
open class Config (
    @JsonNotNull
    open var theme: String,
    @JsonNotNull
    open var unit: String,
) : UTSReactiveObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("Config", "uni_modules/rice-ui/libs/store/useConfig.uts", 1, 13)
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
open class UseNamespace (
    open var b: (blockSuffix: String) -> String,
    open var e: (element: String?) -> String,
    open var m: (modifier: String?) -> String,
    open var `is`: (name: String, state: Boolean?) -> String,
    open var theme: () -> String,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("UseNamespace", "uni_modules/rice-ui/libs/use/useNamespace/index.uts", 2, 13)
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
        return if ((element != null && element != "")) {
            createBem(prefix, "", element!!, "")
        } else {
            ""
        }
    }
    val m = fun(modifier: String?): String {
        return if ((modifier != null && modifier != "")) {
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
typealias BeforeChangeInterceptor = () -> Any
val addUnit = fun(value: Any): String {
    val isNumeric = UTSAndroid.`typeof`(value) == "number" || UTSRegExp("^\\d+(\\.\\d+)?\$", "").test(value as String)
    return if (isNumeric) {
        "" + value + config.unit
    } else {
        (value as String).toString()
    }
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
val hasStrValue = fun(reassignedKVal: Any?): Boolean {
    var kVal = reassignedKVal
    if (kVal == null) {
        return false
    }
    if (UTSAndroid.`typeof`(kVal) != "string") {
        kVal = (kVal as Number).toString()
    }
    return (kVal as String).trim().length > 0
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
        return UTSSourceMapPosition("InterceptorOption", "uni_modules/rice-ui/libs/utils/basic.uts", 208, 13)
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
fun debugWarn(scope: String, mess: String) {
    if ("development" != "production") {
        val err = "[RiceUI] " + scope + ":" + mess
        console.warn(err, " at uni_modules/rice-ui/libs/utils/debug.uts:4")
    }
}
open class SafeAreaInsets (
    @JsonNotNull
    open var top: Number,
    @JsonNotNull
    open var bottom: Number,
    @JsonNotNull
    open var statusBarHeight: Number,
) : UTSReactiveObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("SafeAreaInsets", "uni_modules/rice-ui/libs/use/useSafeArea/index.uts", 1, 13)
    }
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return SafeAreaInsetsReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class SafeAreaInsetsReactiveObject : SafeAreaInsets, IUTSReactive<SafeAreaInsets> {
    override var __v_raw: SafeAreaInsets
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: SafeAreaInsets, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(top = __v_raw.top, bottom = __v_raw.bottom, statusBarHeight = __v_raw.statusBarHeight) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): SafeAreaInsetsReactiveObject {
        return SafeAreaInsetsReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var top: Number
        get() {
            return _tRG(__v_raw, "top", __v_raw.top, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("top")) {
                return
            }
            val oldValue = __v_raw.top
            __v_raw.top = value
            _tRS(__v_raw, "top", oldValue, value)
        }
    override var bottom: Number
        get() {
            return _tRG(__v_raw, "bottom", __v_raw.bottom, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("bottom")) {
                return
            }
            val oldValue = __v_raw.bottom
            __v_raw.bottom = value
            _tRS(__v_raw, "bottom", oldValue, value)
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
}
val safeAreaInsets = ref<SafeAreaInsets>(SafeAreaInsets(top = 0, bottom = 0, statusBarHeight = 25))
fun useSafeArea() {
    var timer: Number? = null
    val getWindowInfo = fun(){
        val windowInfo = uni_getWindowInfo()
        safeAreaInsets.value.bottom = windowInfo.safeAreaInsets.bottom
        safeAreaInsets.value.top = windowInfo.safeAreaInsets.top
        safeAreaInsets.value.statusBarHeight = windowInfo.statusBarHeight
    }
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
fun __uts_large_presetColors_fill_fill_1(__obj: UTSJSONObject): Unit {
    __obj["aliceblue"] = "9ehhb"
    __obj["antiquewhite"] = "9sgk7"
    __obj["aqua"] = "1ekf"
    __obj["aquamarine"] = "4zsno"
    __obj["azure"] = "9eiv3"
    __obj["beige"] = "9lhp8"
    __obj["bisque"] = "9zg04"
    __obj["black"] = "0"
    __obj["blanchedalmond"] = "9zhe5"
    __obj["blue"] = "73"
    __obj["blueviolet"] = "5e31e"
    __obj["brown"] = "6g016"
    __obj["burlywood"] = "8ouiv"
    __obj["cadetblue"] = "3qba8"
    __obj["chartreuse"] = "4zshs"
    __obj["chocolate"] = "87k0u"
    __obj["coral"] = "9yvyo"
    __obj["cornflowerblue"] = "3xael"
    __obj["cornsilk"] = "9zjz0"
    __obj["crimson"] = "8l4xo"
    __obj["cyan"] = "1ekf"
    __obj["darkblue"] = "3v"
    __obj["darkcyan"] = "rkb"
    __obj["darkgoldenrod"] = "776yz"
    __obj["darkgray"] = "6mbhl"
    __obj["darkgreen"] = "jr4"
    __obj["darkgrey"] = "6mbhl"
    __obj["darkkhaki"] = "7ehkb"
    __obj["darkmagenta"] = "5f91n"
    __obj["darkolivegreen"] = "3bzfz"
    __obj["darkorange"] = "9yygw"
    __obj["darkorchid"] = "5z6x8"
    __obj["darkred"] = "5f8xs"
    __obj["darksalmon"] = "9441m"
    __obj["darkseagreen"] = "5lwgf"
    __obj["darkslateblue"] = "2th1n"
    __obj["darkslategray"] = "1ugcv"
    __obj["darkslategrey"] = "1ugcv"
    __obj["darkturquoise"] = "14up"
    __obj["darkviolet"] = "5rw7n"
    __obj["deeppink"] = "9yavn"
    __obj["deepskyblue"] = "11xb"
    __obj["dimgray"] = "442g9"
    __obj["dimgrey"] = "442g9"
    __obj["dodgerblue"] = "16xof"
    __obj["firebrick"] = "6y7tu"
    __obj["floralwhite"] = "9zkds"
    __obj["forestgreen"] = "1cisi"
}
fun __uts_large_presetColors_fill_fill_2(__obj: UTSJSONObject): Unit {
    __obj["fuchsia"] = "9y70f"
    __obj["gainsboro"] = "8m8kc"
    __obj["ghostwhite"] = "9pq0v"
    __obj["goldenrod"] = "8j4f4"
    __obj["gold"] = "9zda8"
    __obj["gray"] = "50i2o"
    __obj["green"] = "pa8"
    __obj["greenyellow"] = "6senj"
    __obj["grey"] = "50i2o"
    __obj["honeydew"] = "9eiuo"
    __obj["hotpink"] = "9yrp0"
    __obj["indianred"] = "80gnw"
    __obj["indigo"] = "2xcoy"
    __obj["ivory"] = "9zldc"
    __obj["khaki"] = "9edu4"
    __obj["lavenderblush"] = "9ziet"
    __obj["lavender"] = "90c8q"
    __obj["lawngreen"] = "4vk74"
    __obj["lemonchiffon"] = "9zkct"
    __obj["lightblue"] = "6s73a"
    __obj["lightcoral"] = "9dtog"
    __obj["lightcyan"] = "8s1rz"
    __obj["lightgoldenrodyellow"] = "9sjiq"
    __obj["lightgray"] = "89jo3"
    __obj["lightgreen"] = "5nkwg"
    __obj["lightgrey"] = "89jo3"
    __obj["lightpink"] = "9z6wx"
    __obj["lightsalmon"] = "9z2ii"
    __obj["lightseagreen"] = "19xgq"
    __obj["lightskyblue"] = "5arju"
    __obj["lightslategray"] = "4nwk9"
    __obj["lightslategrey"] = "4nwk9"
    __obj["lightsteelblue"] = "6wau6"
    __obj["lightyellow"] = "9zlcw"
    __obj["lime"] = "1edc"
    __obj["limegreen"] = "1zcxe"
    __obj["linen"] = "9shk6"
    __obj["magenta"] = "9y70f"
    __obj["maroon"] = "4zsow"
    __obj["mediumaquamarine"] = "40eju"
    __obj["mediumblue"] = "5p"
    __obj["mediumorchid"] = "79qkz"
    __obj["mediumpurple"] = "5r3rv"
    __obj["mediumseagreen"] = "2d9ip"
    __obj["mediumslateblue"] = "4tcku"
    __obj["mediumspringgreen"] = "1di2"
    __obj["mediumturquoise"] = "2uabw"
    __obj["mediumvioletred"] = "7rn9h"
}
fun __uts_large_presetColors_fill_fill_3(__obj: UTSJSONObject): Unit {
    __obj["midnightblue"] = "z980"
    __obj["mintcream"] = "9ljp6"
    __obj["mistyrose"] = "9zg0x"
    __obj["moccasin"] = "9zfzp"
    __obj["navajowhite"] = "9zest"
    __obj["navy"] = "3k"
    __obj["oldlace"] = "9wq92"
    __obj["olive"] = "50hz4"
    __obj["olivedrab"] = "472ub"
    __obj["orange"] = "9z3eo"
    __obj["orangered"] = "9ykg0"
    __obj["orchid"] = "8iu3a"
    __obj["palegoldenrod"] = "9bl4a"
    __obj["palegreen"] = "5yw0o"
    __obj["paleturquoise"] = "6v4ku"
    __obj["palevioletred"] = "8k8lv"
    __obj["papayawhip"] = "9zi6t"
    __obj["peachpuff"] = "9ze0p"
    __obj["peru"] = "80oqn"
    __obj["pink"] = "9z8wb"
    __obj["plum"] = "8nba5"
    __obj["powderblue"] = "6wgdi"
    __obj["purple"] = "4zssg"
    __obj["rebeccapurple"] = "3zk49"
    __obj["red"] = "9y6tc"
    __obj["rosybrown"] = "7cv4f"
    __obj["royalblue"] = "2jvtt"
    __obj["saddlebrown"] = "5fmkz"
    __obj["salmon"] = "9rvci"
    __obj["sandybrown"] = "9jn1c"
    __obj["seagreen"] = "1tdnb"
    __obj["seashell"] = "9zje6"
    __obj["sienna"] = "6973h"
    __obj["silver"] = "7ir40"
    __obj["skyblue"] = "5arjf"
    __obj["slateblue"] = "45e4t"
    __obj["slategray"] = "4e100"
    __obj["slategrey"] = "4e100"
    __obj["snow"] = "9zke2"
    __obj["springgreen"] = "1egv"
    __obj["steelblue"] = "2r1kk"
    __obj["tan"] = "87yx8"
    __obj["teal"] = "pds"
    __obj["thistle"] = "8ggk8"
    __obj["tomato"] = "9yqfb"
    __obj["turquoise"] = "2j4r4"
    __obj["violet"] = "9b10u"
    __obj["wheat"] = "9ld4j"
}
fun __uts_large_presetColors_fill_fill_4(__obj: UTSJSONObject): Unit {
    __obj["white"] = "9zldr"
    __obj["whitesmoke"] = "9lhpx"
    __obj["yellow"] = "9zl6o"
    __obj["yellowgreen"] = "61fzm"
}
fun __uts_large_presetColors_build_0(): UTSJSONObject {
    val __obj: UTSJSONObject = _uO("__\$originalPosition" to UTSSourceMapPosition("__obj", "uni_modules/rice-ui/libs/plugin/coloruts/constant.uts", 158, 11))
    __uts_large_presetColors_fill_fill_1(__obj)
    __uts_large_presetColors_fill_fill_2(__obj)
    __uts_large_presetColors_fill_fill_3(__obj)
    __uts_large_presetColors_fill_fill_4(__obj)
    return __obj
}
val presetColors = __uts_large_presetColors_build_0()
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
        this.fromHsl(_uO("h" to cells[0], "s" to cells[1], "l" to cells[2], "a" to cells[3]))
    }
    private fun fromHsvString(trimStr: String) {
        val cells = splitColorStr(trimStr, parseHSVorHSL)
        this.fromHsv(_uO("h" to cells[0], "s" to cells[1], "v" to cells[2], "a" to cells[3]))
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
        val rgba: UTSJSONObject = _uO("__\$originalPosition" to UTSSourceMapPosition("rgba", "uni_modules/rice-ui/libs/plugin/coloruts/conversion.uts", 347, 15), "r" to Math.round(calc("r")), "g" to Math.round(calc("g")), "b" to Math.round(calc("b")), "a" to (Math.round(calc("a") * 100) / 100))
        return this._c(rgba)
    }
    open fun tint(amount: Number = 10): Coloruts {
        return this.mix(_uO("r" to 255, "g" to 255, "b" to 255, "a" to 1), amount)
    }
    open fun shade(amount: Number = 10): Coloruts {
        return this.mix(_uO("r" to 0, "g" to 0, "b" to 0, "a" to 1), amount)
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
    open var value: Any? = null,
    open var subname: String? = null,
    open var color: String? = null,
    open var icon: String? = null,
    open var iconSize: Any? = null,
    open var iconFontFamily: String? = null,
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
    constructor(__v_raw: ActionSheetAction, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(name = __v_raw.name, value = __v_raw.value, subname = __v_raw.subname, color = __v_raw.color, icon = __v_raw.icon, iconSize = __v_raw.iconSize, iconFontFamily = __v_raw.iconFontFamily, disabled = __v_raw.disabled) {
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
    override var value: Any?
        get() {
            return _tRG(__v_raw, "value", __v_raw.value, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("value")) {
                return
            }
            val oldValue = __v_raw.value
            __v_raw.value = value
            _tRS(__v_raw, "value", oldValue, value)
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
    override var iconFontFamily: String?
        get() {
            return _tRG(__v_raw, "iconFontFamily", __v_raw.iconFontFamily, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("iconFontFamily")) {
                return
            }
            val oldValue = __v_raw.iconFontFamily
            __v_raw.iconFontFamily = value
            _tRS(__v_raw, "iconFontFamily", oldValue, value)
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
        return UTSSourceMapPosition("ActionSheetProps", "uni_modules/rice-ui/components/rice-action-sheet/type.uts", 11, 13)
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
fun __uts_large_lunarYears_fill_fill_1(__arr: UTSArray<Number>): Unit {
    __arr.push(0x04bd8)
    __arr.push(0x04ae0)
    __arr.push(0x0a570)
    __arr.push(0x054d5)
    __arr.push(0x0d260)
    __arr.push(0x0d950)
    __arr.push(0x16554)
    __arr.push(0x056a0)
    __arr.push(0x09ad0)
    __arr.push(0x055d2)
    __arr.push(0x04ae0)
    __arr.push(0x0a5b6)
    __arr.push(0x0a4d0)
    __arr.push(0x0d250)
    __arr.push(0x1d255)
    __arr.push(0x0b540)
    __arr.push(0x0d6a0)
    __arr.push(0x0ada2)
    __arr.push(0x095b0)
    __arr.push(0x14977)
    __arr.push(0x04970)
    __arr.push(0x0a4b0)
    __arr.push(0x0b4b5)
    __arr.push(0x06a50)
    __arr.push(0x06d40)
    __arr.push(0x1ab54)
    __arr.push(0x02b60)
    __arr.push(0x09570)
    __arr.push(0x052f2)
    __arr.push(0x04970)
    __arr.push(0x06566)
    __arr.push(0x0d4a0)
    __arr.push(0x0ea50)
    __arr.push(0x16a95)
    __arr.push(0x05ad0)
    __arr.push(0x02b60)
    __arr.push(0x186e3)
    __arr.push(0x092e0)
    __arr.push(0x1c8d7)
    __arr.push(0x0c950)
    __arr.push(0x0d4a0)
    __arr.push(0x1d8a6)
    __arr.push(0x0b550)
    __arr.push(0x056a0)
    __arr.push(0x1a5b4)
    __arr.push(0x025d0)
    __arr.push(0x092d0)
    __arr.push(0x0d2b2)
}
fun __uts_large_lunarYears_fill_fill_2(__arr: UTSArray<Number>): Unit {
    __arr.push(0x0a950)
    __arr.push(0x0b557)
    __arr.push(0x06ca0)
    __arr.push(0x0b550)
    __arr.push(0x15355)
    __arr.push(0x04da0)
    __arr.push(0x0a5b0)
    __arr.push(0x14573)
    __arr.push(0x052b0)
    __arr.push(0x0a9a8)
    __arr.push(0x0e950)
    __arr.push(0x06aa0)
    __arr.push(0x0aea6)
    __arr.push(0x0ab50)
    __arr.push(0x04b60)
    __arr.push(0x0aae4)
    __arr.push(0x0a570)
    __arr.push(0x05260)
    __arr.push(0x0f263)
    __arr.push(0x0d950)
    __arr.push(0x05b57)
    __arr.push(0x056a0)
    __arr.push(0x096d0)
    __arr.push(0x04dd5)
    __arr.push(0x04ad0)
    __arr.push(0x0a4d0)
    __arr.push(0x0d4d4)
    __arr.push(0x0d250)
    __arr.push(0x0d558)
    __arr.push(0x0b540)
    __arr.push(0x0b6a0)
    __arr.push(0x195a6)
    __arr.push(0x095b0)
    __arr.push(0x049b0)
    __arr.push(0x0a974)
    __arr.push(0x0a4b0)
    __arr.push(0x0b27a)
    __arr.push(0x06a50)
    __arr.push(0x06d40)
    __arr.push(0x0af46)
    __arr.push(0x0ab60)
    __arr.push(0x09570)
    __arr.push(0x04af5)
    __arr.push(0x04970)
    __arr.push(0x064b0)
    __arr.push(0x074a3)
    __arr.push(0x0ea50)
    __arr.push(0x06b58)
}
fun __uts_large_lunarYears_fill_fill_3(__arr: UTSArray<Number>): Unit {
    __arr.push(0x05ac0)
    __arr.push(0x0ab60)
    __arr.push(0x096d5)
    __arr.push(0x092e0)
    __arr.push(0x0c960)
    __arr.push(0x0d954)
    __arr.push(0x0d4a0)
    __arr.push(0x0da50)
    __arr.push(0x07552)
    __arr.push(0x056a0)
    __arr.push(0x0abb7)
    __arr.push(0x025d0)
    __arr.push(0x092d0)
    __arr.push(0x0cab5)
    __arr.push(0x0a950)
    __arr.push(0x0b4a0)
    __arr.push(0x0baa4)
    __arr.push(0x0ad50)
    __arr.push(0x055d9)
    __arr.push(0x04ba0)
    __arr.push(0x0a5b0)
    __arr.push(0x15176)
    __arr.push(0x052b0)
    __arr.push(0x0a930)
    __arr.push(0x07954)
    __arr.push(0x06aa0)
    __arr.push(0x0ad50)
    __arr.push(0x05b52)
    __arr.push(0x04b60)
    __arr.push(0x0a6e6)
    __arr.push(0x0a4e0)
    __arr.push(0x0d260)
    __arr.push(0x0ea65)
    __arr.push(0x0d530)
    __arr.push(0x05aa0)
    __arr.push(0x076a3)
    __arr.push(0x096d0)
    __arr.push(0x04afb)
    __arr.push(0x04ad0)
    __arr.push(0x0a4d0)
    __arr.push(0x1d0b6)
    __arr.push(0x0d250)
    __arr.push(0x0d520)
    __arr.push(0x0dd45)
    __arr.push(0x0b5a0)
    __arr.push(0x056d0)
    __arr.push(0x055b2)
    __arr.push(0x049b0)
}
fun __uts_large_lunarYears_fill_fill_4(__arr: UTSArray<Number>): Unit {
    __arr.push(0x0a577)
    __arr.push(0x0a4b0)
    __arr.push(0x0aa50)
    __arr.push(0x1b255)
    __arr.push(0x06d20)
    __arr.push(0x0ada0)
    __arr.push(0x14b63)
    __arr.push(0x09370)
    __arr.push(0x049f8)
    __arr.push(0x04970)
    __arr.push(0x064b0)
    __arr.push(0x168a6)
    __arr.push(0x0ea50)
    __arr.push(0x06b20)
    __arr.push(0x1a6c4)
    __arr.push(0x0aae0)
    __arr.push(0x092e0)
    __arr.push(0x0d2e3)
    __arr.push(0x0c960)
    __arr.push(0x0d557)
    __arr.push(0x0d4a0)
    __arr.push(0x0da50)
    __arr.push(0x05d55)
    __arr.push(0x056a0)
    __arr.push(0x0a6d0)
    __arr.push(0x055d4)
    __arr.push(0x052d0)
    __arr.push(0x0a9b8)
    __arr.push(0x0a950)
    __arr.push(0x0b4a0)
    __arr.push(0x0b6a6)
    __arr.push(0x0ad50)
    __arr.push(0x055a0)
    __arr.push(0x0aba4)
    __arr.push(0x0a5b0)
    __arr.push(0x052b0)
    __arr.push(0x0b273)
    __arr.push(0x06930)
    __arr.push(0x07337)
    __arr.push(0x06aa0)
    __arr.push(0x0ad50)
    __arr.push(0x14b55)
    __arr.push(0x04b60)
    __arr.push(0x0a570)
    __arr.push(0x054e4)
    __arr.push(0x0d160)
    __arr.push(0x0e968)
    __arr.push(0x0d520)
}
fun __uts_large_lunarYears_fill_fill_5(__arr: UTSArray<Number>): Unit {
    __arr.push(0x0daa0)
    __arr.push(0x16aa6)
    __arr.push(0x056d0)
    __arr.push(0x04ae0)
    __arr.push(0x0a9d4)
    __arr.push(0x0a2d0)
    __arr.push(0x0d150)
    __arr.push(0x0f252)
    __arr.push(0x0d520)
}
fun __uts_large_lunarYears_build_0(): UTSArray<Number> {
    val __arr = _uA<Number>()
    __uts_large_lunarYears_fill_fill_1(__arr)
    __uts_large_lunarYears_fill_fill_2(__arr)
    __uts_large_lunarYears_fill_fill_3(__arr)
    __uts_large_lunarYears_fill_fill_4(__arr)
    __uts_large_lunarYears_fill_fill_5(__arr)
    return __arr
}
val lunarYears = __uts_large_lunarYears_build_0()
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
        return UTSSourceMapPosition("InfoType", "uni_modules/rice-ui/components/rice-calendar/lunar.uts", 249, 13)
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
        return UTSSourceMapPosition("LunarInfoType", "uni_modules/rice-ui/components/rice-calendar/lunar.uts", 255, 13)
    }
}
open class Lunar : IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("Lunar", "uni_modules/rice-ui/components/rice-calendar/lunar.uts", 275, 14)
    }
    private var lunarYearDaysMap = Map<Number, Number>()
    private var lunarMonthDaysMap = Map<Number, UTSArray<Number>>()
    constructor(){}
    open fun toChinaMonth(reassignedM: Number, leap: Boolean = false): String {
        var m = reassignedM
        m = Math.max(1, m)
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
val checkboxGroupInjectKey = "CheckboxGroupKey-" + getRandomStr()
open class GenApp : BaseApp {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        setCurrentInstance(__ins)
        __ins.proxy = this
        GenApp.setup(this)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenApp) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenApp
            val _cache = __ins.renderCache
            var firstBackTime: Number = 0
            onLaunch(fun(_options){
                console.log("App Launch", " at App.uvue:9")
                checkSystemInfo()
                setTimeout(fun(){
                    checkWindowInfo()
                }
                , 500)
            }
            )
            onAppShow(fun(_options){
                console.log("App Show", " at App.uvue:17")
                uni_onKeyboardHeightChange(fun(res: OnKeyboardHeightChangeCallbackResult){
                    state.keyboardHeight = res.height
                }
                )
            }
            )
            onAppHide(fun(){
                console.log("App Hide", " at App.uvue:25")
                uni_offKeyboardHeightChange(null)
            }
            )
            onLastPageBackPress(fun(){
                console.log("App LastPageBackPress", " at App.uvue:32")
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
            )
            onExit(fun(){
                console.log("App Exit", " at App.uvue:49")
            }
            )
            return fun(): Any? {
                return null
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("theme-light" to _pS(_uM("--navbar-background" to "#f5f5f5", "--search-background" to "transparent", "--search-input-background" to "rgba(0, 0, 0, 0.04)", "--primary-color" to "#1989fa", "--primary-color-1" to "#e6f7ff", "--primary-color-7" to "#0b68d4", "--success-color" to "#07c160", "--success-color-1" to "#e6ffee", "--success-color-7" to "#009c50", "--warning-color" to "#e6a23c", "--warning-color-1" to "#fffbe8", "--warning-color-7" to "#bf7e28", "--error-color" to "#f56c6c", "--error-color-1" to "#fff2f0", "--error-color-7" to "#cf5155", "--button-default-border" to "#eaecf1", "--button-default-background" to "#fff", "--button-default-hover-background" to "#f1f1f1", "--text-color-white" to "#f5f5f5", "--border-color" to "#ebedf0", "--text-color-1" to "#02070F", "--text-color-2" to "#666", "--text-color-3" to "#999", "--text-color-4" to "#111", "--background-color-1" to "rgba(0, 0, 0, 0.50)", "--background-color-2" to "#FFF", "--cell-active-color" to "#f2f3f5", "--uploader-background" to "#f7f8fa")), "theme-dark" to _pS(_uM("--navbar-background" to "#181818", "--search-background" to "transparent", "--search-input-background" to "#333", "--primary-color" to "#1989fa", "--primary-color-1" to "#111c2b", "--primary-color-7" to "#3d98e8", "--success-color" to "#07c160", "--success-color-1" to "#11231b", "--success-color-7" to "#27bc6a", "--warning-color" to "#ff976a", "--warning-color-1" to "#281f15", "--warning-color-7" to "#dcae5e", "--button-default-border" to "#383838", "--button-default-background" to "#383838", "--button-default-hover-background" to "#4b4b4b", "--text-color-white" to "#f5f5f5", "--border-color" to "#ebedf0", "--error-color" to "#ee0a24", "--error-color-1" to "#2a1a1b", "--error-color-7" to "#e88e8c", "--text-color-1" to "#F5F5F5", "--text-color-2" to "#CCC", "--text-color-3" to "#999", "--text-color-4" to "#F5F5F5", "--background-color-1" to "#111", "--background-color-2" to "rgba(255, 255, 255, 0.13)", "--cell-active-color" to "#3a3a3c", "--uploader-background" to "#262727")), "flex" to _pS(_uM("display" to "flex", "flexDirection" to "row")), "items-center" to _pS(_uM("alignItems" to "center")), "justify-left" to _pS(_uM("justifyContent" to "flex-start")), "justify-center" to _pS(_uM("justifyContent" to "center")), "justify-right" to _pS(_uM("justifyContent" to "flex-end")), "justify-between" to _pS(_uM("justifyContent" to "space-between")), "justify-around" to _pS(_uM("justifyContent" to "space-around")))
            }
    }
}
val GenAppClass = CreateVueAppComponent(GenApp::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "app", name = "", inheritAttrs = true, inject = Map(), props = Map(), propsNeedCastKeys = _uA(), emits = Map(), components = Map(), styles = GenApp.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenApp.setup(props as GenApp)
    }
    )
}
, fun(instance): GenApp {
    return GenApp(instance)
}
)
val getRandomDigits = fun(n: Number): String {
    var result = ""
    result += Math.floor(Math.random() * 9) + 1
    run {
        var i: Number = 1
        while(i < n){
            result += Math.floor(Math.random() * 10)
            i++
        }
    }
    return result
}
val addUnit__1 = fun(value: Any): String {
    val isNumeric = UTSAndroid.`typeof`(value) == "number" || UTSRegExp("^\\d+(\\.\\d+)?\$", "").test(value as String)
    return if (isNumeric) {
        "" + value + state.unit
    } else {
        (value as String).toString()
    }
}
val hasStrValue__1 = fun(reassignedKVal: Any?): Boolean {
    var kVal = reassignedKVal
    if (kVal == null) {
        return false
    }
    if (UTSAndroid.`typeof`(kVal) != "string") {
        kVal = (kVal as Number).toString()
    }
    return (kVal as String).trim().length > 0
}
val isImage = fun(url: String?): Boolean {
    if (url == null) {
        return false
    }
    val imageExtensions = UTSRegExp("\\.(jpg|jpeg|png|gif|bmp|webp|svg|ico)\$", "i")
    return imageExtensions.test(url)
}
val isVideo = fun(url: String?): Boolean {
    if (url == null) {
        return false
    }
    val videoExtensions = UTSRegExp("\\.(mp4|webm|ogg|mov|avi|wmv|flv|mkv)\$", "i")
    return videoExtensions.test(url)
}
open class FontData__1 (
    @JsonNotNull
    open var name: String,
    @JsonNotNull
    open var code: String,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("FontData", "componnets/MyIcon/font.uts", 1, 13)
    }
}
val fontData__1 = _uA(
    FontData__1(name = "expand", code = "\ue809"),
    FontData__1(name = "del", code = "\ue80a"),
    FontData__1(name = "multiple-horizontal", code = "\ue80b"),
    FontData__1(name = "left", code = "\ue80c"),
    FontData__1(name = "left-circle", code = "\ue80d"),
    FontData__1(name = "down-circle", code = "\ue80e"),
    FontData__1(name = "caret-down", code = "\ue80f"),
    FontData__1(name = "double-left", code = "\ue810"),
    FontData__1(name = "caret-right", code = "\ue811"),
    FontData__1(name = "double-right", code = "\ue812"),
    FontData__1(name = "double-down", code = "\ue813"),
    FontData__1(name = "down", code = "\ue814"),
    FontData__1(name = "arrow-right", code = "\ue815"),
    FontData__1(name = "caret-left", code = "\ue816"),
    FontData__1(name = "arrow-down", code = "\ue817"),
    FontData__1(name = "arrow-left", code = "\ue818"),
    FontData__1(name = "up", code = "\ue6ed"),
    FontData__1(name = "arrow-rise", code = "\ue6e8"),
    FontData__1(name = "double-up", code = "\ue6e9"),
    FontData__1(name = "to-right", code = "\ue6ec"),
    FontData__1(name = "up-circle", code = "\ue7f9"),
    FontData__1(name = "sort-fill", code = "\ue6eb"),
    FontData__1(name = "to-top", code = "\ue7fa"),
    FontData__1(name = "to-left", code = "\ue7fb"),
    FontData__1(name = "menu-fold", code = "\ue7fc"),
    FontData__1(name = "swap", code = "\ue7fd"),
    FontData__1(name = "drag-arrow", code = "\ue7fe"),
    FontData__1(name = "sort-fill-1", code = "\ue7ff"),
    FontData__1(name = "to-bottom", code = "\ue800"),
    FontData__1(name = "caret-up", code = "\ue6ea"),
    FontData__1(name = "rotate-left", code = "\ue801"),
    FontData__1(name = "arrow-up", code = "\ue802"),
    FontData__1(name = "arrow-fall", code = "\ue803"),
    FontData__1(name = "right", code = "\ue804"),
    FontData__1(name = "menu-unfold", code = "\ue805"),
    FontData__1(name = "rotate-right", code = "\ue806"),
    FontData__1(name = "shrink", code = "\ue807"),
    FontData__1(name = "right-circle", code = "\ue808"),
    FontData__1(name = "bold", code = "\ue6ee"),
    FontData__1(name = "filter-fill", code = "\ue6ef"),
    FontData__1(name = "deleteall", code = "\ue7eb"),
    FontData__1(name = "brush", code = "\ue7ec"),
    FontData__1(name = "font-colors", code = "\ue7ed"),
    FontData__1(name = "edit", code = "\ue7ee"),
    FontData__1(name = "filter", code = "\ue7ef"),
    FontData__1(name = "find-replace", code = "\ue7f0"),
    FontData__1(name = "eraser", code = "\ue7f1"),
    FontData__1(name = "copy", code = "\ue7f2"),
    FontData__1(name = "delete", code = "\ue7f3"),
    FontData__1(name = "circular", code = "\ue7f4"),
    FontData__1(name = "bg-colors", code = "\ue7f5"),
    FontData__1(name = "align-right", code = "\ue7f6"),
    FontData__1(name = "align-center", code = "\ue7f7"),
    FontData__1(name = "align-left", code = "\ue7f8"),
    FontData__1(name = "unordered-list", code = "\ue7d6"),
    FontData__1(name = "undo", code = "\ue7d7"),
    FontData__1(name = "zoom-out", code = "\ue7d8"),
    FontData__1(name = "sort-ascending", code = "\ue7d9"),
    FontData__1(name = "scissor", code = "\ue7da"),
    FontData__1(name = "quote", code = "\ue7db"),
    FontData__1(name = "sort-descending", code = "\ue7dc"),
    FontData__1(name = "link", code = "\ue7dd"),
    FontData__1(name = "ordered-list", code = "\ue7de"),
    FontData__1(name = "h3", code = "\ue7df"),
    FontData__1(name = "h4", code = "\ue7e0"),
    FontData__1(name = "italic", code = "\ue7e1"),
    FontData__1(name = "redo", code = "\ue7e2"),
    FontData__1(name = "highlight", code = "\ue7e3"),
    FontData__1(name = "original-size", code = "\ue7e4"),
    FontData__1(name = "h1", code = "\ue7e5"),
    FontData__1(name = "h5", code = "\ue7e6"),
    FontData__1(name = "oblique-line", code = "\ue7e7"),
    FontData__1(name = "line-height", code = "\ue7e8"),
    FontData__1(name = "h7", code = "\ue7e9"),
    FontData__1(name = "h2", code = "\ue7ea"),
    FontData__1(name = "apps", code = "\ue7cb"),
    FontData__1(name = "application", code = "\ue7cc"),
    FontData__1(name = "no-wifi", code = "\ue6f7"),
    FontData__1(name = "no-result", code = "\ue7cd"),
    FontData__1(name = "no-product", code = "\ue7ce"),
    FontData__1(name = "no-message", code = "\ue7cf"),
    FontData__1(name = "no-content", code = "\ue6f6"),
    FontData__1(name = "no-comment", code = "\ue7d0"),
    FontData__1(name = "no-collection", code = "\ue6f5"),
    FontData__1(name = "failpayment", code = "\ue7d1"),
    FontData__1(name = "formula", code = "\ue6f0"),
    FontData__1(name = "zoom-in", code = "\ue6f4"),
    FontData__1(name = "sort", code = "\ue7d2"),
    FontData__1(name = "textarea", code = "\ue6f3"),
    FontData__1(name = "paste", code = "\ue6f2"),
    FontData__1(name = "h6", code = "\ue6f1"),
    FontData__1(name = "number", code = "\ue7d3"),
    FontData__1(name = "underline", code = "\ue7d4"),
    FontData__1(name = "strikethrough", code = "\ue7d5"),
    FontData__1(name = "drag-dot", code = "\ue7bc"),
    FontData__1(name = "dice", code = "\ue6fd"),
    FontData__1(name = "drive-file", code = "\ue7bd"),
    FontData__1(name = "email", code = "\ue7be"),
    FontData__1(name = "drag-dot-vertical", code = "\ue7bf"),
    FontData__1(name = "compass", code = "\ue6fc"),
    FontData__1(name = "dashboard", code = "\ue7c0"),
    FontData__1(name = "common", code = "\ue6fb"),
    FontData__1(name = "desktop", code = "\ue7c1"),
    FontData__1(name = "copyright", code = "\ue7c2"),
    FontData__1(name = "cloud", code = "\ue7c3"),
    FontData__1(name = "company", code = "\ue7c4"),
    FontData__1(name = "command", code = "\ue7c5"),
    FontData__1(name = "camera", code = "\ue6fa"),
    FontData__1(name = "camera-fill", code = "\ue6f9"),
    FontData__1(name = "branch", code = "\ue6f8"),
    FontData__1(name = "calendar-line", code = "\ue7c6"),
    FontData__1(name = "bug", code = "\ue7c7"),
    FontData__1(name = "bulb", code = "\ue7c8"),
    FontData__1(name = "book", code = "\ue7c9"),
    FontData__1(name = "archive", code = "\ue7ca"),
    FontData__1(name = "gift", code = "\ue700"),
    FontData__1(name = "image-failloading", code = "\ue7aa"),
    FontData__1(name = "interaction", code = "\ue7ab"),
    FontData__1(name = "image-close", code = "\ue7ac"),
    FontData__1(name = "Fire", code = "\ue7ad"),
    FontData__1(name = "image", code = "\ue7ae"),
    FontData__1(name = "idcard", code = "\ue7af"),
    FontData__1(name = "folder-add", code = "\ue7b0"),
    FontData__1(name = "face-frown-fill", code = "\ue6fe"),
    FontData__1(name = "folder", code = "\ue7b1"),
    FontData__1(name = "folder-delete", code = "\ue7b2"),
    FontData__1(name = "file-video", code = "\ue6ff"),
    FontData__1(name = "file", code = "\ue7b3"),
    FontData__1(name = "file-pdf", code = "\ue7b4"),
    FontData__1(name = "experiment", code = "\ue7b5"),
    FontData__1(name = "file-audio", code = "\ue7b6"),
    FontData__1(name = "face-meh-fill", code = "\ue7b7"),
    FontData__1(name = "file-image", code = "\ue7b8"),
    FontData__1(name = "empty", code = "\ue7b9"),
    FontData__1(name = "face-smile-fill", code = "\ue7ba"),
    FontData__1(name = "ear", code = "\ue7bb"),
    FontData__1(name = "mobile", code = "\ue7a2"),
    FontData__1(name = "lock", code = "\ue702"),
    FontData__1(name = "mind-mapping", code = "\ue7a3"),
    FontData__1(name = "location", code = "\ue7a4"),
    FontData__1(name = "loop", code = "\ue7a5"),
    FontData__1(name = "language", code = "\ue701"),
    FontData__1(name = "locate", code = "\ue7a6"),
    FontData__1(name = "keyboard", code = "\ue7a7"),
    FontData__1(name = "loading", code = "\ue7a8"),
    FontData__1(name = "layout", code = "\ue7a9"),
    FontData__1(name = "phone", code = "\ue705"),
    FontData__1(name = "printer", code = "\ue798"),
    FontData__1(name = "pen-fill", code = "\ue799"),
    FontData__1(name = "organization", code = "\ue79a"),
    FontData__1(name = "notification-close", code = "\ue704"),
    FontData__1(name = "old-version", code = "\ue79b"),
    FontData__1(name = "moon", code = "\ue79c"),
    FontData__1(name = "notification", code = "\ue79d"),
    FontData__1(name = "nav", code = "\ue79e"),
    FontData__1(name = "mosaic", code = "\ue79f"),
    FontData__1(name = "man", code = "\ue703"),
    FontData__1(name = "moon-fill", code = "\ue7a0"),
    FontData__1(name = "menu", code = "\ue7a1"),
    FontData__1(name = "tags", code = "\ue788"),
    FontData__1(name = "tag", code = "\ue789"),
    FontData__1(name = "thunderbolt", code = "\ue78a"),
    FontData__1(name = "sun", code = "\ue709"),
    FontData__1(name = "store", code = "\ue708"),
    FontData__1(name = "sun-fill", code = "\ue78b"),
    FontData__1(name = "subscribed", code = "\ue78c"),
    FontData__1(name = "stamp", code = "\ue78d"),
    FontData__1(name = "subscribe", code = "\ue78e"),
    FontData__1(name = "skin", code = "\ue78f"),
    FontData__1(name = "storage", code = "\ue790"),
    FontData__1(name = "subscribe-add", code = "\ue791"),
    FontData__1(name = "shake", code = "\ue792"),
    FontData__1(name = "safe", code = "\ue707"),
    FontData__1(name = "public", code = "\ue706"),
    FontData__1(name = "pen", code = "\ue793"),
    FontData__1(name = "robot", code = "\ue794"),
    FontData__1(name = "robot-add", code = "\ue795"),
    FontData__1(name = "pushpin", code = "\ue796"),
    FontData__1(name = "qrcode", code = "\ue797"),
    FontData__1(name = "eye-fill", code = "\ue778"),
    FontData__1(name = "code", code = "\ue779"),
    FontData__1(name = "code-square", code = "\ue70e"),
    FontData__1(name = "Export", code = "\ue77a"),
    FontData__1(name = "download", code = "\ue77b"),
    FontData__1(name = "clock-circle-fill", code = "\ue77c"),
    FontData__1(name = "code-block", code = "\ue77d"),
    FontData__1(name = "cloud-download", code = "\ue77e"),
    FontData__1(name = "buble-circle-fill", code = "\ue70d"),
    FontData__1(name = "barcode", code = "\ue77f"),
    FontData__1(name = "at", code = "\ue780"),
    FontData__1(name = "wifi", code = "\ue70c"),
    FontData__1(name = "tool", code = "\ue70a"),
    FontData__1(name = "woman", code = "\ue781"),
    FontData__1(name = "video-camera", code = "\ue70b"),
    FontData__1(name = "user", code = "\ue782"),
    FontData__1(name = "user-group", code = "\ue783"),
    FontData__1(name = "time-line", code = "\ue784"),
    FontData__1(name = "trophy", code = "\ue785"),
    FontData__1(name = "user-add", code = "\ue786"),
    FontData__1(name = "unlock", code = "\ue787"),
    FontData__1(name = "refresh", code = "\ue765"),
    FontData__1(name = "more", code = "\ue766"),
    FontData__1(name = "more-vertical", code = "\ue767"),
    FontData__1(name = "mic", code = "\ue713"),
    FontData__1(name = "module-fill", code = "\ue768"),
    FontData__1(name = "mfill", code = "\ue769"),
    FontData__1(name = "message", code = "\ue76a"),
    FontData__1(name = "message-banned", code = "\ue76b"),
    FontData__1(name = "lightning-circle-fill", code = "\ue712"),
    FontData__1(name = "import", code = "\ue76c"),
    FontData__1(name = "list", code = "\ue76d"),
    FontData__1(name = "Launch", code = "\ue76e"),
    FontData__1(name = "home", code = "\ue711"),
    FontData__1(name = "home-fill", code = "\ue76f"),
    FontData__1(name = "heart", code = "\ue770"),
    FontData__1(name = "history", code = "\ue771"),
    FontData__1(name = "headset", code = "\ue772"),
    FontData__1(name = "heart-fill", code = "\ue773"),
    FontData__1(name = "headset-off", code = "\ue710"),
    FontData__1(name = "headset-fill", code = "\ue774"),
    FontData__1(name = "headset-off-fill", code = "\ue775"),
    FontData__1(name = "eye", code = "\ue776"),
    FontData__1(name = "eye-invisible", code = "\ue777"),
    FontData__1(name = "eye-invisible-fill", code = "\ue70f"),
    FontData__1(name = "live-broadcast", code = "\ue753"),
    FontData__1(name = "fullscreen", code = "\ue71b"),
    FontData__1(name = "fullscreen-exit", code = "\ue71a"),
    FontData__1(name = "forward", code = "\ue754"),
    FontData__1(name = "backward", code = "\ue755"),
    FontData__1(name = "voice", code = "\ue719"),
    FontData__1(name = "upload", code = "\ue756"),
    FontData__1(name = "translate", code = "\ue718"),
    FontData__1(name = "thumb-up", code = "\ue757"),
    FontData__1(name = "sync", code = "\ue758"),
    FontData__1(name = "thumb-down", code = "\ue759"),
    FontData__1(name = "thumb-up-fill", code = "\ue75a"),
    FontData__1(name = "star", code = "\ue717"),
    FontData__1(name = "thumb-down-fill", code = "\ue75b"),
    FontData__1(name = "share-internal", code = "\ue75c"),
    FontData__1(name = "star-fill", code = "\ue75d"),
    FontData__1(name = "share-external", code = "\ue716"),
    FontData__1(name = "settings", code = "\ue75e"),
    FontData__1(name = "share-alt", code = "\ue75f"),
    FontData__1(name = "send", code = "\ue760"),
    FontData__1(name = "select-all", code = "\ue715"),
    FontData__1(name = "poweroff", code = "\ue714"),
    FontData__1(name = "search-line", code = "\ue761"),
    FontData__1(name = "save", code = "\ue762"),
    FontData__1(name = "scan", code = "\ue763"),
    FontData__1(name = "reply", code = "\ue764"),
    FontData__1(name = "check-half-square-fill", code = "\ue746"),
    FontData__1(name = "check-circle", code = "\ue724"),
    FontData__1(name = "check-circle-radio-fill", code = "\ue723"),
    FontData__1(name = "check-circle-fill", code = "\ue747"),
    FontData__1(name = "sound", code = "\ue722"),
    FontData__1(name = "skip-next-fill", code = "\ue720"),
    FontData__1(name = "sound-fill", code = "\ue721"),
    FontData__1(name = "skip-previous", code = "\ue748"),
    FontData__1(name = "skip-previous-fill", code = "\ue749"),
    FontData__1(name = "skip-next", code = "\ue74a"),
    FontData__1(name = "record-stop", code = "\ue71f"),
    FontData__1(name = "record", code = "\ue74b"),
    FontData__1(name = "play-circle", code = "\ue74c"),
    FontData__1(name = "play-circle-fill", code = "\ue74d"),
    FontData__1(name = "play-arrow", code = "\ue71e"),
    FontData__1(name = "play-arrow-fill", code = "\ue74e"),
    FontData__1(name = "pause-circle", code = "\ue71d"),
    FontData__1(name = "pause", code = "\ue74f"),
    FontData__1(name = "mute-fill", code = "\ue71c"),
    FontData__1(name = "pause-circle-fill", code = "\ue750"),
    FontData__1(name = "music", code = "\ue751"),
    FontData__1(name = "mute", code = "\ue752"),
    FontData__1(name = "page-fill", code = "\ue73b"),
    FontData__1(name = "minus-square", code = "\ue72e"),
    FontData__1(name = "minus-square-3px", code = "\ue73c"),
    FontData__1(name = "minus-circle", code = "\ue73d"),
    FontData__1(name = "minus-circle-fill", code = "\ue72d"),
    FontData__1(name = "info", code = "\ue73e"),
    FontData__1(name = "info-circle", code = "\ue72c"),
    FontData__1(name = "info-circle-fill", code = "\ue73f"),
    FontData__1(name = "exclamation", code = "\ue72b"),
    FontData__1(name = "exclamation-polygon-fill", code = "\ue740"),
    FontData__1(name = "exclamation-circle", code = "\ue72a"),
    FontData__1(name = "exclamation-circle-fill", code = "\ue741"),
    FontData__1(name = "doublecheck", code = "\ue729"),
    FontData__1(name = "close", code = "\ue728"),
    FontData__1(name = "division", code = "\ue742"),
    FontData__1(name = "close-circle", code = "\ue743"),
    FontData__1(name = "close-circle-fill", code = "\ue727"),
    FontData__1(name = "clock-circle", code = "\ue744"),
    FontData__1(name = "check", code = "\ue726"),
    FontData__1(name = "check-square", code = "\ue745"),
    FontData__1(name = "check-square-fill", code = "\ue725"),
    FontData__1(name = "uncheck-square", code = "\ue733"),
    FontData__1(name = "stop", code = "\ue732"),
    FontData__1(name = "uncheck-circle", code = "\ue734"),
    FontData__1(name = "question-circle", code = "\ue735"),
    FontData__1(name = "question", code = "\ue736"),
    FontData__1(name = "question-circle-fill", code = "\ue731"),
    FontData__1(name = "plus-square-3px", code = "\ue730"),
    FontData__1(name = "plus", code = "\ue737"),
    FontData__1(name = "plus-square", code = "\ue738"),
    FontData__1(name = "plus-circle", code = "\ue739"),
    FontData__1(name = "plus-circle-fill", code = "\ue72f"),
    FontData__1(name = "minus", code = "\ue73a")
) as UTSArray<FontData__1>
val GenComponnetsMyIconIndexClass = CreateVueComponent(GenComponnetsMyIconIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponnetsMyIconIndex.name, inheritAttrs = GenComponnetsMyIconIndex.inheritAttrs, inject = GenComponnetsMyIconIndex.inject, props = GenComponnetsMyIconIndex.props, propsNeedCastKeys = GenComponnetsMyIconIndex.propsNeedCastKeys, emits = GenComponnetsMyIconIndex.emits, components = GenComponnetsMyIconIndex.components, styles = GenComponnetsMyIconIndex.styles, styleIsolation = UniSharedDataComponentStyleIsolation.AppAndPage, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponnetsMyIconIndex.setup(props as GenComponnetsMyIconIndex)
    }
    )
}
, fun(instance, renderer): GenComponnetsMyIconIndex {
    return GenComponnetsMyIconIndex(instance)
}
)
val GenComponnetsMyNavbarIndexClass = CreateVueComponent(GenComponnetsMyNavbarIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponnetsMyNavbarIndex.inheritAttrs, inject = GenComponnetsMyNavbarIndex.inject, props = GenComponnetsMyNavbarIndex.props, propsNeedCastKeys = GenComponnetsMyNavbarIndex.propsNeedCastKeys, emits = GenComponnetsMyNavbarIndex.emits, components = GenComponnetsMyNavbarIndex.components, styles = GenComponnetsMyNavbarIndex.styles, styleIsolation = UniSharedDataComponentStyleIsolation.App, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponnetsMyNavbarIndex.setup(props as GenComponnetsMyNavbarIndex)
    }
    )
}
, fun(instance, renderer): GenComponnetsMyNavbarIndex {
    return GenComponnetsMyNavbarIndex(instance)
}
)
open class BookItem (
    @JsonNotNull
    open var id: String,
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var author: String,
    open var hasUnread: Boolean? = null,
    @JsonNotNull
    open var lastChapter: String,
    @JsonNotNull
    open var lastUpdateTime: String,
    @JsonNotNull
    open var readChapter: String,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("BookItem", "data/book.uts", 1, 13)
    }
}
val bookList = _uA(
    BookItem(id = "1", title = "三体", author = "刘慈欣", hasUnread = true, lastChapter = "第三部 死神永生 第27章", lastUpdateTime = "5小时前", readChapter = "第二部 死神诞生 第2章"),
    BookItem(id = "2", title = "活着", author = "余华", lastChapter = "全文完", lastUpdateTime = "3小时前", readChapter = "第20章"),
    BookItem(id = "3", title = "百年孤独", author = "加西亚·马尔克斯", hasUnread = true, lastChapter = "第二章", lastUpdateTime = "1天前", readChapter = "第一章")
) as UTSArray<BookItem>
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
val GenUniModulesUniFabButtonComponentsUniFabButtonUniFabButtonClass = CreateVueComponent(GenUniModulesUniFabButtonComponentsUniFabButtonUniFabButton::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenUniModulesUniFabButtonComponentsUniFabButtonUniFabButton.inheritAttrs, inject = GenUniModulesUniFabButtonComponentsUniFabButtonUniFabButton.inject, props = GenUniModulesUniFabButtonComponentsUniFabButtonUniFabButton.props, propsNeedCastKeys = GenUniModulesUniFabButtonComponentsUniFabButtonUniFabButton.propsNeedCastKeys, emits = GenUniModulesUniFabButtonComponentsUniFabButtonUniFabButton.emits, components = GenUniModulesUniFabButtonComponentsUniFabButtonUniFabButton.components, styles = GenUniModulesUniFabButtonComponentsUniFabButtonUniFabButton.styles, externalClasses = _uA(
        "plusClass"
    ), setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesUniFabButtonComponentsUniFabButtonUniFabButton.setup(props as GenUniModulesUniFabButtonComponentsUniFabButtonUniFabButton)
    }
    )
}
, fun(instance, renderer): GenUniModulesUniFabButtonComponentsUniFabButtonUniFabButton {
    return GenUniModulesUniFabButtonComponentsUniFabButtonUniFabButton(instance)
}
)
val GenComponnetsMyAvatarIndexClass = CreateVueComponent(GenComponnetsMyAvatarIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponnetsMyAvatarIndex.inheritAttrs, inject = GenComponnetsMyAvatarIndex.inject, props = GenComponnetsMyAvatarIndex.props, propsNeedCastKeys = GenComponnetsMyAvatarIndex.propsNeedCastKeys, emits = GenComponnetsMyAvatarIndex.emits, components = GenComponnetsMyAvatarIndex.components, styles = GenComponnetsMyAvatarIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponnetsMyAvatarIndex.setup(props as GenComponnetsMyAvatarIndex)
    }
    )
}
, fun(instance, renderer): GenComponnetsMyAvatarIndex {
    return GenComponnetsMyAvatarIndex(instance)
}
)
open class DiscussItem (
    @JsonNotNull
    open var id: String,
    @JsonNotNull
    open var avatar: String,
    @JsonNotNull
    open var name: String,
    @JsonNotNull
    open var content: String,
    @JsonNotNull
    open var goodNum: Number,
    @JsonNotNull
    open var viewNum: Number,
    @JsonNotNull
    open var likeNum: Number,
    @JsonNotNull
    open var shareNum: Number,
    @JsonNotNull
    open var isGood: Boolean = false,
    @JsonNotNull
    open var isView: Boolean = false,
    @JsonNotNull
    open var isLike: Boolean = false,
    @JsonNotNull
    open var isShare: Boolean = false,
) : UTSReactiveObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("DiscussItem", "data/discuss.uts", 1, 13)
    }
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return DiscussItemReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class DiscussItemReactiveObject : DiscussItem, IUTSReactive<DiscussItem> {
    override var __v_raw: DiscussItem
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: DiscussItem, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, avatar = __v_raw.avatar, name = __v_raw.name, content = __v_raw.content, goodNum = __v_raw.goodNum, viewNum = __v_raw.viewNum, likeNum = __v_raw.likeNum, shareNum = __v_raw.shareNum, isGood = __v_raw.isGood, isView = __v_raw.isView, isLike = __v_raw.isLike, isShare = __v_raw.isShare) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): DiscussItemReactiveObject {
        return DiscussItemReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var id: String
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var avatar: String
        get() {
            return _tRG(__v_raw, "avatar", __v_raw.avatar, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("avatar")) {
                return
            }
            val oldValue = __v_raw.avatar
            __v_raw.avatar = value
            _tRS(__v_raw, "avatar", oldValue, value)
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
    override var content: String
        get() {
            return _tRG(__v_raw, "content", __v_raw.content, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("content")) {
                return
            }
            val oldValue = __v_raw.content
            __v_raw.content = value
            _tRS(__v_raw, "content", oldValue, value)
        }
    override var goodNum: Number
        get() {
            return _tRG(__v_raw, "goodNum", __v_raw.goodNum, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("goodNum")) {
                return
            }
            val oldValue = __v_raw.goodNum
            __v_raw.goodNum = value
            _tRS(__v_raw, "goodNum", oldValue, value)
        }
    override var viewNum: Number
        get() {
            return _tRG(__v_raw, "viewNum", __v_raw.viewNum, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("viewNum")) {
                return
            }
            val oldValue = __v_raw.viewNum
            __v_raw.viewNum = value
            _tRS(__v_raw, "viewNum", oldValue, value)
        }
    override var likeNum: Number
        get() {
            return _tRG(__v_raw, "likeNum", __v_raw.likeNum, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("likeNum")) {
                return
            }
            val oldValue = __v_raw.likeNum
            __v_raw.likeNum = value
            _tRS(__v_raw, "likeNum", oldValue, value)
        }
    override var shareNum: Number
        get() {
            return _tRG(__v_raw, "shareNum", __v_raw.shareNum, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("shareNum")) {
                return
            }
            val oldValue = __v_raw.shareNum
            __v_raw.shareNum = value
            _tRS(__v_raw, "shareNum", oldValue, value)
        }
    override var isGood: Boolean
        get() {
            return _tRG(__v_raw, "isGood", __v_raw.isGood, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("isGood")) {
                return
            }
            val oldValue = __v_raw.isGood
            __v_raw.isGood = value
            _tRS(__v_raw, "isGood", oldValue, value)
        }
    override var isView: Boolean
        get() {
            return _tRG(__v_raw, "isView", __v_raw.isView, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("isView")) {
                return
            }
            val oldValue = __v_raw.isView
            __v_raw.isView = value
            _tRS(__v_raw, "isView", oldValue, value)
        }
    override var isLike: Boolean
        get() {
            return _tRG(__v_raw, "isLike", __v_raw.isLike, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("isLike")) {
                return
            }
            val oldValue = __v_raw.isLike
            __v_raw.isLike = value
            _tRS(__v_raw, "isLike", oldValue, value)
        }
    override var isShare: Boolean
        get() {
            return _tRG(__v_raw, "isShare", __v_raw.isShare, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("isShare")) {
                return
            }
            val oldValue = __v_raw.isShare
            __v_raw.isShare = value
            _tRS(__v_raw, "isShare", oldValue, value)
        }
}
val getCharLen = fun(len: Number): String {
    var str = ""
    run {
        var i: Number = 0
        while(i < len){
            str += String.fromCharCode(Math.floor(Math.random() * 6656) + 0x4e00)
            i++
        }
    }
    return str
}
val discussListFun = fun(): UTSArray<DiscussItem> {
    val aa: UTSArray<DiscussItem> = _uA()
    run {
        var i: Number = 0
        while(i < 10){
            aa.push(DiscussItem(id = "" + i, avatar = "", name = getCharLen(Math.floor(Math.random() * 10)), content = getCharLen(Math.floor(Math.random() * 200)), likeNum = Math.floor(Math.random() * 100), viewNum = Math.floor(Math.random() * 100), goodNum = Math.floor(Math.random() * 100), shareNum = Math.floor(Math.random() * 100), isLike = Math.random() > 0.5, isView = Math.random() > 0.5, isGood = Math.random() > 0.5, isShare = Math.random() > 0.5))
            i++
        }
    }
    return aa
}
val GenPagesDiscussItemContentClass = CreateVueComponent(GenPagesDiscussItemContent::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenPagesDiscussItemContent.inheritAttrs, inject = GenPagesDiscussItemContent.inject, props = GenPagesDiscussItemContent.props, propsNeedCastKeys = GenPagesDiscussItemContent.propsNeedCastKeys, emits = GenPagesDiscussItemContent.emits, components = GenPagesDiscussItemContent.components, styles = GenPagesDiscussItemContent.styles, styleIsolation = UniSharedDataComponentStyleIsolation.App, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesDiscussItemContent.setup(props as GenPagesDiscussItemContent)
    }
    )
}
, fun(instance, renderer): GenPagesDiscussItemContent {
    return GenPagesDiscussItemContent(instance)
}
)
val GenPagesDiscussItemAichatClass = CreateVueComponent(GenPagesDiscussItemAichat::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenPagesDiscussItemAichat.inheritAttrs, inject = GenPagesDiscussItemAichat.inject, props = GenPagesDiscussItemAichat.props, propsNeedCastKeys = GenPagesDiscussItemAichat.propsNeedCastKeys, emits = GenPagesDiscussItemAichat.emits, components = GenPagesDiscussItemAichat.components, styles = GenPagesDiscussItemAichat.styles)
}
, fun(instance, renderer): GenPagesDiscussItemAichat {
    return GenPagesDiscussItemAichat(instance)
}
)
open class BadgeItem (
    @JsonNotNull
    open var name: String,
    open var type: String? = null,
    open var isDot: Boolean? = null,
    open var dotNum: Number? = null,
) : UTSReactiveObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("BadgeItem", "pages/discuss/index.uvue", 31, 7)
    }
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return BadgeItemReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class BadgeItemReactiveObject : BadgeItem, IUTSReactive<BadgeItem> {
    override var __v_raw: BadgeItem
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: BadgeItem, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(name = __v_raw.name, type = __v_raw.type, isDot = __v_raw.isDot, dotNum = __v_raw.dotNum) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): BadgeItemReactiveObject {
        return BadgeItemReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
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
    override var type: String?
        get() {
            return _tRG(__v_raw, "type", __v_raw.type, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("type")) {
                return
            }
            val oldValue = __v_raw.type
            __v_raw.type = value
            _tRS(__v_raw, "type", oldValue, value)
        }
    override var isDot: Boolean?
        get() {
            return _tRG(__v_raw, "isDot", __v_raw.isDot, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("isDot")) {
                return
            }
            val oldValue = __v_raw.isDot
            __v_raw.isDot = value
            _tRS(__v_raw, "isDot", oldValue, value)
        }
    override var dotNum: Number?
        get() {
            return _tRG(__v_raw, "dotNum", __v_raw.dotNum, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("dotNum")) {
                return
            }
            val oldValue = __v_raw.dotNum
            __v_raw.dotNum = value
            _tRS(__v_raw, "dotNum", oldValue, value)
        }
}
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
val GenPagesDiscussDetailIndexClass = CreateVueComponent(GenPagesDiscussDetailIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesDiscussDetailIndex.inheritAttrs, inject = GenPagesDiscussDetailIndex.inject, props = GenPagesDiscussDetailIndex.props, propsNeedCastKeys = GenPagesDiscussDetailIndex.propsNeedCastKeys, emits = GenPagesDiscussDetailIndex.emits, components = GenPagesDiscussDetailIndex.components, styles = GenPagesDiscussDetailIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesDiscussDetailIndex.setup(props as GenPagesDiscussDetailIndex)
    }
    )
}
, fun(instance, renderer): GenPagesDiscussDetailIndex {
    return GenPagesDiscussDetailIndex(instance, renderer)
}
)
open class BtnStyleType (
    open var padding: String? = null,
    open var margin: String? = null,
    open var width: String? = null,
    open var height: String? = null,
    open var color: String? = null,
    open var background: String? = null,
) : UTSReactiveObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("BtnStyleType", "componnets/MyButton/type.uts", 9, 13)
    }
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return BtnStyleTypeReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class BtnStyleTypeReactiveObject : BtnStyleType, IUTSReactive<BtnStyleType> {
    override var __v_raw: BtnStyleType
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: BtnStyleType, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(padding = __v_raw.padding, margin = __v_raw.margin, width = __v_raw.width, height = __v_raw.height, color = __v_raw.color, background = __v_raw.background) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): BtnStyleTypeReactiveObject {
        return BtnStyleTypeReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var padding: String?
        get() {
            return _tRG(__v_raw, "padding", __v_raw.padding, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("padding")) {
                return
            }
            val oldValue = __v_raw.padding
            __v_raw.padding = value
            _tRS(__v_raw, "padding", oldValue, value)
        }
    override var margin: String?
        get() {
            return _tRG(__v_raw, "margin", __v_raw.margin, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("margin")) {
                return
            }
            val oldValue = __v_raw.margin
            __v_raw.margin = value
            _tRS(__v_raw, "margin", oldValue, value)
        }
    override var width: String?
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
    override var height: String?
        get() {
            return _tRG(__v_raw, "height", __v_raw.height, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("height")) {
                return
            }
            val oldValue = __v_raw.height
            __v_raw.height = value
            _tRS(__v_raw, "height", oldValue, value)
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
    override var background: String?
        get() {
            return _tRG(__v_raw, "background", __v_raw.background, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("background")) {
                return
            }
            val oldValue = __v_raw.background
            __v_raw.background = value
            _tRS(__v_raw, "background", oldValue, value)
        }
}
val GenComponnetsMyButtonIndexClass = CreateVueComponent(GenComponnetsMyButtonIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponnetsMyButtonIndex.name, inheritAttrs = GenComponnetsMyButtonIndex.inheritAttrs, inject = GenComponnetsMyButtonIndex.inject, props = GenComponnetsMyButtonIndex.props, propsNeedCastKeys = GenComponnetsMyButtonIndex.propsNeedCastKeys, emits = GenComponnetsMyButtonIndex.emits, components = GenComponnetsMyButtonIndex.components, styles = GenComponnetsMyButtonIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponnetsMyButtonIndex.setup(props as GenComponnetsMyButtonIndex)
    }
    )
}
, fun(instance, renderer): GenComponnetsMyButtonIndex {
    return GenComponnetsMyButtonIndex(instance)
}
)
typealias UploaderStatus = String
open class UploaderFileItem (
    @JsonNotNull
    open var url: String,
    open var poster: String? = null,
    open var fileName: String? = null,
    open var status: UploaderStatus? = null,
    open var fileType: String? = null,
    open var message: String? = null,
    open var percent: Number? = null,
    open var size: Number? = null,
    open var duration: Number? = null,
    open var deletable: Boolean? = null,
    open var uid: String? = null,
    open var name: String? = null,
    open var action: String? = null,
    open var formData: UTSJSONObject? = null,
    open var header: UTSJSONObject? = null,
) : UTSReactiveObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("UploaderFileItem", "componnets/MyUploader/type.uts", 3, 13)
    }
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return UploaderFileItemReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class UploaderFileItemReactiveObject : UploaderFileItem, IUTSReactive<UploaderFileItem> {
    override var __v_raw: UploaderFileItem
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: UploaderFileItem, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(url = __v_raw.url, poster = __v_raw.poster, fileName = __v_raw.fileName, status = __v_raw.status, fileType = __v_raw.fileType, message = __v_raw.message, percent = __v_raw.percent, size = __v_raw.size, duration = __v_raw.duration, deletable = __v_raw.deletable, uid = __v_raw.uid, name = __v_raw.name, action = __v_raw.action, formData = __v_raw.formData, header = __v_raw.header) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UploaderFileItemReactiveObject {
        return UploaderFileItemReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var url: String
        get() {
            return _tRG(__v_raw, "url", __v_raw.url, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("url")) {
                return
            }
            val oldValue = __v_raw.url
            __v_raw.url = value
            _tRS(__v_raw, "url", oldValue, value)
        }
    override var poster: String?
        get() {
            return _tRG(__v_raw, "poster", __v_raw.poster, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("poster")) {
                return
            }
            val oldValue = __v_raw.poster
            __v_raw.poster = value
            _tRS(__v_raw, "poster", oldValue, value)
        }
    override var fileName: String?
        get() {
            return _tRG(__v_raw, "fileName", __v_raw.fileName, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fileName")) {
                return
            }
            val oldValue = __v_raw.fileName
            __v_raw.fileName = value
            _tRS(__v_raw, "fileName", oldValue, value)
        }
    override var status: UploaderStatus?
        get() {
            return _tRG(__v_raw, "status", __v_raw.status, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("status")) {
                return
            }
            val oldValue = __v_raw.status
            __v_raw.status = value
            _tRS(__v_raw, "status", oldValue, value)
        }
    override var fileType: String?
        get() {
            return _tRG(__v_raw, "fileType", __v_raw.fileType, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fileType")) {
                return
            }
            val oldValue = __v_raw.fileType
            __v_raw.fileType = value
            _tRS(__v_raw, "fileType", oldValue, value)
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
    override var percent: Number?
        get() {
            return _tRG(__v_raw, "percent", __v_raw.percent, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("percent")) {
                return
            }
            val oldValue = __v_raw.percent
            __v_raw.percent = value
            _tRS(__v_raw, "percent", oldValue, value)
        }
    override var size: Number?
        get() {
            return _tRG(__v_raw, "size", __v_raw.size, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("size")) {
                return
            }
            val oldValue = __v_raw.size
            __v_raw.size = value
            _tRS(__v_raw, "size", oldValue, value)
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
    override var deletable: Boolean?
        get() {
            return _tRG(__v_raw, "deletable", __v_raw.deletable, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("deletable")) {
                return
            }
            val oldValue = __v_raw.deletable
            __v_raw.deletable = value
            _tRS(__v_raw, "deletable", oldValue, value)
        }
    override var uid: String?
        get() {
            return _tRG(__v_raw, "uid", __v_raw.uid, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("uid")) {
                return
            }
            val oldValue = __v_raw.uid
            __v_raw.uid = value
            _tRS(__v_raw, "uid", oldValue, value)
        }
    override var name: String?
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
    override var action: String?
        get() {
            return _tRG(__v_raw, "action", __v_raw.action, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("action")) {
                return
            }
            val oldValue = __v_raw.action
            __v_raw.action = value
            _tRS(__v_raw, "action", oldValue, value)
        }
    override var formData: UTSJSONObject?
        get() {
            return _tRG(__v_raw, "formData", __v_raw.formData, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("formData")) {
                return
            }
            val oldValue = __v_raw.formData
            __v_raw.formData = value
            _tRS(__v_raw, "formData", oldValue, value)
        }
    override var header: UTSJSONObject?
        get() {
            return _tRG(__v_raw, "header", __v_raw.header, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("header")) {
                return
            }
            val oldValue = __v_raw.header
            __v_raw.header = value
            _tRS(__v_raw, "header", oldValue, value)
        }
}
open class UploaderSuccess (
    @JsonNotNull
    open var statusCode: Number,
    @JsonNotNull
    open var data: String,
    @JsonNotNull
    open var file: UploaderFileItem,
) : UTSReactiveObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("UploaderSuccess", "componnets/MyUploader/type.uts", 20, 13)
    }
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return UploaderSuccessReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class UploaderSuccessReactiveObject : UploaderSuccess, IUTSReactive<UploaderSuccess> {
    override var __v_raw: UploaderSuccess
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: UploaderSuccess, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(statusCode = __v_raw.statusCode, data = __v_raw.data, file = __v_raw.file) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UploaderSuccessReactiveObject {
        return UploaderSuccessReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var statusCode: Number
        get() {
            return _tRG(__v_raw, "statusCode", __v_raw.statusCode, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("statusCode")) {
                return
            }
            val oldValue = __v_raw.statusCode
            __v_raw.statusCode = value
            _tRS(__v_raw, "statusCode", oldValue, value)
        }
    override var data: String
        get() {
            return _tRG(__v_raw, "data", __v_raw.data, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("data")) {
                return
            }
            val oldValue = __v_raw.data
            __v_raw.data = value
            _tRS(__v_raw, "data", oldValue, value)
        }
    override var file: UploaderFileItem
        get() {
            return _tRG(__v_raw, "file", __v_raw.file, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("file")) {
                return
            }
            val oldValue = __v_raw.file
            __v_raw.file = value
            _tRS(__v_raw, "file", oldValue, value)
        }
}
open class UploaderFail (
    @JsonNotNull
    open var errCode: Number,
    @JsonNotNull
    open var statusCode: Number,
    open var data: Any? = null,
    @JsonNotNull
    open var errMsg: String,
    @JsonNotNull
    open var file: UploaderFileItem,
) : UTSReactiveObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("UploaderFail", "componnets/MyUploader/type.uts", 25, 13)
    }
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return UploaderFailReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class UploaderFailReactiveObject : UploaderFail, IUTSReactive<UploaderFail> {
    override var __v_raw: UploaderFail
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: UploaderFail, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(errCode = __v_raw.errCode, statusCode = __v_raw.statusCode, data = __v_raw.data, errMsg = __v_raw.errMsg, file = __v_raw.file) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UploaderFailReactiveObject {
        return UploaderFailReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var errCode: Number
        get() {
            return _tRG(__v_raw, "errCode", __v_raw.errCode, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("errCode")) {
                return
            }
            val oldValue = __v_raw.errCode
            __v_raw.errCode = value
            _tRS(__v_raw, "errCode", oldValue, value)
        }
    override var statusCode: Number
        get() {
            return _tRG(__v_raw, "statusCode", __v_raw.statusCode, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("statusCode")) {
                return
            }
            val oldValue = __v_raw.statusCode
            __v_raw.statusCode = value
            _tRS(__v_raw, "statusCode", oldValue, value)
        }
    override var data: Any?
        get() {
            return _tRG(__v_raw, "data", __v_raw.data, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("data")) {
                return
            }
            val oldValue = __v_raw.data
            __v_raw.data = value
            _tRS(__v_raw, "data", oldValue, value)
        }
    override var errMsg: String
        get() {
            return _tRG(__v_raw, "errMsg", __v_raw.errMsg, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("errMsg")) {
                return
            }
            val oldValue = __v_raw.errMsg
            __v_raw.errMsg = value
            _tRS(__v_raw, "errMsg", oldValue, value)
        }
    override var file: UploaderFileItem
        get() {
            return _tRG(__v_raw, "file", __v_raw.file, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("file")) {
                return
            }
            val oldValue = __v_raw.file
            __v_raw.file = value
            _tRS(__v_raw, "file", oldValue, value)
        }
}
open class UploaderComplete (
    @JsonNotNull
    open var successList: UTSArray<UploaderSuccess>,
    @JsonNotNull
    open var failList: UTSArray<UploaderFail>,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("UploaderComplete", "componnets/MyUploader/type.uts", 32, 13)
    }
}
var fileId: Number = 1
val getFileId = fun(): String {
    return "" + (Date.now() + fileId++)
}
val getFileExtension = fun(url: String): String {
    val lastDotIndex = url.lastIndexOf(".")
    if (lastDotIndex == -1 || lastDotIndex == url.length - 1) {
        return ""
    }
    return url.slice(lastDotIndex + 1)
}
val getFileType = fun(file: UploaderFileItem): String {
    if (file.fileType != null && file.fileType != "") {
        return file.fileType!!
    }
    if (isImage(file.url)) {
        return "image"
    }
    if (isVideo(file.url)) {
        return "video"
    }
    return getFileExtension(file.url)
}
val GenComponnetsMyUploaderIndexClass = CreateVueComponent(GenComponnetsMyUploaderIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponnetsMyUploaderIndex.name, inheritAttrs = GenComponnetsMyUploaderIndex.inheritAttrs, inject = GenComponnetsMyUploaderIndex.inject, props = GenComponnetsMyUploaderIndex.props, propsNeedCastKeys = GenComponnetsMyUploaderIndex.propsNeedCastKeys, emits = GenComponnetsMyUploaderIndex.emits, components = GenComponnetsMyUploaderIndex.components, styles = GenComponnetsMyUploaderIndex.styles, styleIsolation = UniSharedDataComponentStyleIsolation.AppAndPage, setup = fun(props: ComponentPublicInstance, ctx: SetupContext): Any? {
        return GenComponnetsMyUploaderIndex.setup(props as GenComponnetsMyUploaderIndex, ctx)
    }
    )
}
, fun(instance, renderer): GenComponnetsMyUploaderIndex {
    return GenComponnetsMyUploaderIndex(instance)
}
)
open class ComItemType (
    @JsonNotNull
    open var id: Number,
    @JsonNotNull
    open var icon: String,
    @JsonNotNull
    open var text: String,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("ComItemType", "componnets/MyEditCom/type.uts", 4, 13)
    }
}
val GenComponnetsMyEditComIndexClass = CreateVueComponent(GenComponnetsMyEditComIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponnetsMyEditComIndex.inheritAttrs, inject = GenComponnetsMyEditComIndex.inject, props = GenComponnetsMyEditComIndex.props, propsNeedCastKeys = GenComponnetsMyEditComIndex.propsNeedCastKeys, emits = GenComponnetsMyEditComIndex.emits, components = GenComponnetsMyEditComIndex.components, styles = GenComponnetsMyEditComIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponnetsMyEditComIndex.setup(props as GenComponnetsMyEditComIndex)
    }
    )
}
, fun(instance, renderer): GenComponnetsMyEditComIndex {
    return GenComponnetsMyEditComIndex(instance)
}
)
open class FormDataType (
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var content: String,
    open var formData: UTSJSONObject? = null,
) : UTSReactiveObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("FormDataType", "pages/discuss-issue/type.uts", 1, 13)
    }
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return FormDataTypeReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class FormDataTypeReactiveObject : FormDataType, IUTSReactive<FormDataType> {
    override var __v_raw: FormDataType
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: FormDataType, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(title = __v_raw.title, content = __v_raw.content, formData = __v_raw.formData) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): FormDataTypeReactiveObject {
        return FormDataTypeReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var title: String
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
    override var content: String
        get() {
            return _tRG(__v_raw, "content", __v_raw.content, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("content")) {
                return
            }
            val oldValue = __v_raw.content
            __v_raw.content = value
            _tRS(__v_raw, "content", oldValue, value)
        }
    override var formData: UTSJSONObject?
        get() {
            return _tRG(__v_raw, "formData", __v_raw.formData, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("formData")) {
                return
            }
            val oldValue = __v_raw.formData
            __v_raw.formData = value
            _tRS(__v_raw, "formData", oldValue, value)
        }
}
val GenPagesDiscussIssueIndexClass = CreateVueComponent(GenPagesDiscussIssueIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesDiscussIssueIndex.inheritAttrs, inject = GenPagesDiscussIssueIndex.inject, props = GenPagesDiscussIssueIndex.props, propsNeedCastKeys = GenPagesDiscussIssueIndex.propsNeedCastKeys, emits = GenPagesDiscussIssueIndex.emits, components = GenPagesDiscussIssueIndex.components, styles = GenPagesDiscussIssueIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesDiscussIssueIndex.setup(props as GenPagesDiscussIssueIndex)
    }
    )
}
, fun(instance, renderer): GenPagesDiscussIssueIndex {
    return GenPagesDiscussIssueIndex(instance, renderer)
}
)
val GenPagesDiscussIssueLinkPageClass = CreateVueComponent(GenPagesDiscussIssueLinkPage::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesDiscussIssueLinkPage.inheritAttrs, inject = GenPagesDiscussIssueLinkPage.inject, props = GenPagesDiscussIssueLinkPage.props, propsNeedCastKeys = GenPagesDiscussIssueLinkPage.propsNeedCastKeys, emits = GenPagesDiscussIssueLinkPage.emits, components = GenPagesDiscussIssueLinkPage.components, styles = GenPagesDiscussIssueLinkPage.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesDiscussIssueLinkPage.setup(props as GenPagesDiscussIssueLinkPage)
    }
    )
}
, fun(instance, renderer): GenPagesDiscussIssueLinkPage {
    return GenPagesDiscussIssueLinkPage(instance, renderer)
}
)
val GenUniModulesUniBadgeViewComponentsUniBadgeViewUniBadgeViewClass = CreateVueComponent(GenUniModulesUniBadgeViewComponentsUniBadgeViewUniBadgeView::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenUniModulesUniBadgeViewComponentsUniBadgeViewUniBadgeView.inheritAttrs, inject = GenUniModulesUniBadgeViewComponentsUniBadgeViewUniBadgeView.inject, props = GenUniModulesUniBadgeViewComponentsUniBadgeViewUniBadgeView.props, propsNeedCastKeys = GenUniModulesUniBadgeViewComponentsUniBadgeViewUniBadgeView.propsNeedCastKeys, emits = GenUniModulesUniBadgeViewComponentsUniBadgeViewUniBadgeView.emits, components = GenUniModulesUniBadgeViewComponentsUniBadgeViewUniBadgeView.components, styles = GenUniModulesUniBadgeViewComponentsUniBadgeViewUniBadgeView.styles, externalClasses = _uA(
        "badgeClass"
    ), setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesUniBadgeViewComponentsUniBadgeViewUniBadgeView.setup(props as GenUniModulesUniBadgeViewComponentsUniBadgeViewUniBadgeView)
    }
    )
}
, fun(instance, renderer): GenUniModulesUniBadgeViewComponentsUniBadgeViewUniBadgeView {
    return GenUniModulesUniBadgeViewComponentsUniBadgeViewUniBadgeView(instance)
}
)
val GenComponnetsMyCellIndexClass = CreateVueComponent(GenComponnetsMyCellIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponnetsMyCellIndex.inheritAttrs, inject = GenComponnetsMyCellIndex.inject, props = GenComponnetsMyCellIndex.props, propsNeedCastKeys = GenComponnetsMyCellIndex.propsNeedCastKeys, emits = GenComponnetsMyCellIndex.emits, components = GenComponnetsMyCellIndex.components, styles = GenComponnetsMyCellIndex.styles, styleIsolation = UniSharedDataComponentStyleIsolation.App, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponnetsMyCellIndex.setup(props as GenComponnetsMyCellIndex)
    }
    )
}
, fun(instance, renderer): GenComponnetsMyCellIndex {
    return GenComponnetsMyCellIndex(instance)
}
)
val GenComponnetsMyCellGroupIndexClass = CreateVueComponent(GenComponnetsMyCellGroupIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponnetsMyCellGroupIndex.inheritAttrs, inject = GenComponnetsMyCellGroupIndex.inject, props = GenComponnetsMyCellGroupIndex.props, propsNeedCastKeys = GenComponnetsMyCellGroupIndex.propsNeedCastKeys, emits = GenComponnetsMyCellGroupIndex.emits, components = GenComponnetsMyCellGroupIndex.components, styles = GenComponnetsMyCellGroupIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponnetsMyCellGroupIndex.setup(props as GenComponnetsMyCellGroupIndex)
    }
    )
}
, fun(instance, renderer): GenComponnetsMyCellGroupIndex {
    return GenComponnetsMyCellGroupIndex(instance)
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
open class SearchRecordItem (
    @JsonNotNull
    open var id: String,
    @JsonNotNull
    open var text: String,
) : UTSReactiveObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("SearchRecordItem", "pages/search/index.uvue", 53, 7)
    }
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return SearchRecordItemReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class SearchRecordItemReactiveObject : SearchRecordItem, IUTSReactive<SearchRecordItem> {
    override var __v_raw: SearchRecordItem
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: SearchRecordItem, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(id = __v_raw.id, text = __v_raw.text) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): SearchRecordItemReactiveObject {
        return SearchRecordItemReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var id: String
        get() {
            return _tRG(__v_raw, "id", __v_raw.id, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("id")) {
                return
            }
            val oldValue = __v_raw.id
            __v_raw.id = value
            _tRS(__v_raw, "id", oldValue, value)
        }
    override var text: String
        get() {
            return _tRG(__v_raw, "text", __v_raw.text, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("text")) {
                return
            }
            val oldValue = __v_raw.text
            __v_raw.text = value
            _tRS(__v_raw, "text", oldValue, value)
        }
}
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
val GenComponnetsMySwitchIndexClass = CreateVueComponent(GenComponnetsMySwitchIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponnetsMySwitchIndex.name, inheritAttrs = GenComponnetsMySwitchIndex.inheritAttrs, inject = GenComponnetsMySwitchIndex.inject, props = GenComponnetsMySwitchIndex.props, propsNeedCastKeys = GenComponnetsMySwitchIndex.propsNeedCastKeys, emits = GenComponnetsMySwitchIndex.emits, components = GenComponnetsMySwitchIndex.components, styles = GenComponnetsMySwitchIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponnetsMySwitchIndex.setup(props as GenComponnetsMySwitchIndex)
    }
    )
}
, fun(instance, renderer): GenComponnetsMySwitchIndex {
    return GenComponnetsMySwitchIndex(instance)
}
)
val GenPagesSettingIndexClass = CreateVueComponent(GenPagesSettingIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesSettingIndex.inheritAttrs, inject = GenPagesSettingIndex.inject, props = GenPagesSettingIndex.props, propsNeedCastKeys = GenPagesSettingIndex.propsNeedCastKeys, emits = GenPagesSettingIndex.emits, components = GenPagesSettingIndex.components, styles = GenPagesSettingIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesSettingIndex.setup(props as GenPagesSettingIndex)
    }
    )
}
, fun(instance, renderer): GenPagesSettingIndex {
    return GenPagesSettingIndex(instance, renderer)
}
)
val GenPagesFeedbackIndexClass = CreateVueComponent(GenPagesFeedbackIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesFeedbackIndex.inheritAttrs, inject = GenPagesFeedbackIndex.inject, props = GenPagesFeedbackIndex.props, propsNeedCastKeys = GenPagesFeedbackIndex.propsNeedCastKeys, emits = GenPagesFeedbackIndex.emits, components = GenPagesFeedbackIndex.components, styles = GenPagesFeedbackIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesFeedbackIndex.setup(props as GenPagesFeedbackIndex)
    }
    )
}
, fun(instance, renderer): GenPagesFeedbackIndex {
    return GenPagesFeedbackIndex(instance, renderer)
}
)
val GenPagesExplanationIndexClass = CreateVueComponent(GenPagesExplanationIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesExplanationIndex.inheritAttrs, inject = GenPagesExplanationIndex.inject, props = GenPagesExplanationIndex.props, propsNeedCastKeys = GenPagesExplanationIndex.propsNeedCastKeys, emits = GenPagesExplanationIndex.emits, components = GenPagesExplanationIndex.components, styles = GenPagesExplanationIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesExplanationIndex.setup(props as GenPagesExplanationIndex)
    }
    )
}
, fun(instance, renderer): GenPagesExplanationIndex {
    return GenPagesExplanationIndex(instance, renderer)
}
)
val GenUniModulesRiceUiComponentsRiceOverlayRiceOverlayClass = CreateVueComponent(GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay.name, inheritAttrs = GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay.inheritAttrs, inject = GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay.inject, props = GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay.props, propsNeedCastKeys = GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay.propsNeedCastKeys, emits = GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay.emits, components = GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay.components, styles = GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay.styles, styleIsolation = UniSharedDataComponentStyleIsolation.AppAndPage, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay.setup(props as GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay)
    }
    )
}
, fun(instance, renderer): GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay {
    return GenUniModulesRiceUiComponentsRiceOverlayRiceOverlay(instance)
}
)
val GenUniModulesRiceUiComponentsRiceIconRiceIconClass = CreateVueComponent(GenUniModulesRiceUiComponentsRiceIconRiceIcon::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesRiceUiComponentsRiceIconRiceIcon.name, inheritAttrs = GenUniModulesRiceUiComponentsRiceIconRiceIcon.inheritAttrs, inject = GenUniModulesRiceUiComponentsRiceIconRiceIcon.inject, props = GenUniModulesRiceUiComponentsRiceIconRiceIcon.props, propsNeedCastKeys = GenUniModulesRiceUiComponentsRiceIconRiceIcon.propsNeedCastKeys, emits = GenUniModulesRiceUiComponentsRiceIconRiceIcon.emits, components = GenUniModulesRiceUiComponentsRiceIconRiceIcon.components, styles = GenUniModulesRiceUiComponentsRiceIconRiceIcon.styles, styleIsolation = UniSharedDataComponentStyleIsolation.AppAndPage, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesRiceUiComponentsRiceIconRiceIcon.setup(props as GenUniModulesRiceUiComponentsRiceIconRiceIcon)
    }
    )
}
, fun(instance, renderer): GenUniModulesRiceUiComponentsRiceIconRiceIcon {
    return GenUniModulesRiceUiComponentsRiceIconRiceIcon(instance)
}
)
val GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheetClass = CreateVueComponent(GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet.name, inheritAttrs = GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet.inheritAttrs, inject = GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet.inject, props = GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet.props, propsNeedCastKeys = GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet.propsNeedCastKeys, emits = GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet.emits, components = GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet.components, styles = GenUniModulesRiceUiComponentsRiceActionSheetRiceActionSheet.styles, styleIsolation = UniSharedDataComponentStyleIsolation.AppAndPage, setup = fun(props: ComponentPublicInstance): Any? {
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
open class UseLoadingOptions (
    @JsonNotNull
    open var rotateRef: Ref<UniElement?>,
    @JsonNotNull
    open var circularRef: Ref<UniElement?>,
    @JsonNotNull
    open var timingFunction: LoadingTimingFunction,
    @JsonNotNull
    open var mode: LoadingMode,
    @JsonNotNull
    open var color: ComputedRef<String>,
    @JsonNotNull
    open var size: Any,
    @JsonNotNull
    open var duration: Number,
) : UTSObject(), IUTSSourceMap {
    override fun `__$getOriginalPosition`(): UTSSourceMapPosition? {
        return UTSSourceMapPosition("UseLoadingOptions", "uni_modules/rice-ui/components/rice-loading/useLoading.uts", 3, 13)
    }
}
fun useLoading(options: UseLoadingOptions) {
    var aniIns: UniAnimation? = null
    val startAnimate = fun(): UTSPromise<Unit> {
        return wrapUTSPromise(suspend {
                val rotateRef = options.rotateRef
                val timingFunction = options.timingFunction
                val duration = options.duration
                await(nextTick())
                aniIns = rotateRef.value?.animate(_uA(
                    UniAnimationKeyframe(transform = "rotate(0deg)"),
                    UniAnimationKeyframe(transform = "rotate(360deg)")
                ), UniAnimationOption(duration = duration, easing = timingFunction, iterations = Infinity))
        })
    }
    var timer: Number? = null
    var drawContext: DrawableContext? = null
    val easeInOutCubic = fun(t: Number): Number {
        return if (t < 0.5) {
            4 * t * t * t
        } else {
            (t - 1) * (2 * t - 2) * (2 * t - 2) + 1
        }
    }
    val drawCircular = fun(ctx: DrawableContext){
        var rotate: Number = 0
        val size = getPxNum(options.size)
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
    watch(fun(): String {
        return options.color.value
    }
    , fun(){
        initCircular()
    }
    )
    val init = fun(): UTSPromise<Unit> {
        return wrapUTSPromise(suspend {
                await(nextTick())
                initCircular()
                startAnimate()
        })
    }
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
    return VueComponentOptions(type = "component", name = GenUniModulesRiceUiComponentsRiceLoadingRiceLoading.name, inheritAttrs = GenUniModulesRiceUiComponentsRiceLoadingRiceLoading.inheritAttrs, inject = GenUniModulesRiceUiComponentsRiceLoadingRiceLoading.inject, props = GenUniModulesRiceUiComponentsRiceLoadingRiceLoading.props, propsNeedCastKeys = GenUniModulesRiceUiComponentsRiceLoadingRiceLoading.propsNeedCastKeys, emits = GenUniModulesRiceUiComponentsRiceLoadingRiceLoading.emits, components = GenUniModulesRiceUiComponentsRiceLoadingRiceLoading.components, styles = GenUniModulesRiceUiComponentsRiceLoadingRiceLoading.styles, styleIsolation = UniSharedDataComponentStyleIsolation.AppAndPage, externalClasses = _uA(
        "textClass"
    ), setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesRiceUiComponentsRiceLoadingRiceLoading.setup(props as GenUniModulesRiceUiComponentsRiceLoadingRiceLoading)
    }
    )
}
, fun(instance, renderer): GenUniModulesRiceUiComponentsRiceLoadingRiceLoading {
    return GenUniModulesRiceUiComponentsRiceLoadingRiceLoading(instance)
}
)
val iconSizeTypes: UTSJSONObject = _uO("__\$originalPosition" to UTSSourceMapPosition("iconSizeTypes", "uni_modules/rice-ui/components/rice-button/utils.uts", 1, 14), "large" to "18px", "default" to "16px", "small" to "14px", "mini" to "12px")
val loadingSizeTypes: UTSJSONObject = _uO("__\$originalPosition" to UTSSourceMapPosition("loadingSizeTypes", "uni_modules/rice-ui/components/rice-button/utils.uts", 7, 14), "large" to "20px", "default" to "18px", "small" to "16px", "mini" to "14px")
val GenUniModulesRiceUiComponentsRiceButtonRiceButtonClass = CreateVueComponent(GenUniModulesRiceUiComponentsRiceButtonRiceButton::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesRiceUiComponentsRiceButtonRiceButton.name, inheritAttrs = GenUniModulesRiceUiComponentsRiceButtonRiceButton.inheritAttrs, inject = GenUniModulesRiceUiComponentsRiceButtonRiceButton.inject, props = GenUniModulesRiceUiComponentsRiceButtonRiceButton.props, propsNeedCastKeys = GenUniModulesRiceUiComponentsRiceButtonRiceButton.propsNeedCastKeys, emits = GenUniModulesRiceUiComponentsRiceButtonRiceButton.emits, components = GenUniModulesRiceUiComponentsRiceButtonRiceButton.components, styles = GenUniModulesRiceUiComponentsRiceButtonRiceButton.styles, styleIsolation = UniSharedDataComponentStyleIsolation.AppAndPage, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesRiceUiComponentsRiceButtonRiceButton.setup(props as GenUniModulesRiceUiComponentsRiceButtonRiceButton)
    }
    )
}
, fun(instance, renderer): GenUniModulesRiceUiComponentsRiceButtonRiceButton {
    return GenUniModulesRiceUiComponentsRiceButtonRiceButton(instance)
}
)
val GenUniModulesRiceUiComponentsRiceDialogRiceDialogClass = CreateVueComponent(GenUniModulesRiceUiComponentsRiceDialogRiceDialog::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenUniModulesRiceUiComponentsRiceDialogRiceDialog.name, inheritAttrs = GenUniModulesRiceUiComponentsRiceDialogRiceDialog.inheritAttrs, inject = GenUniModulesRiceUiComponentsRiceDialogRiceDialog.inject, props = GenUniModulesRiceUiComponentsRiceDialogRiceDialog.props, propsNeedCastKeys = GenUniModulesRiceUiComponentsRiceDialogRiceDialog.propsNeedCastKeys, emits = GenUniModulesRiceUiComponentsRiceDialogRiceDialog.emits, components = GenUniModulesRiceUiComponentsRiceDialogRiceDialog.components, styles = GenUniModulesRiceUiComponentsRiceDialogRiceDialog.styles, styleIsolation = UniSharedDataComponentStyleIsolation.AppAndPage, setup = fun(props: ComponentPublicInstance): Any? {
        return GenUniModulesRiceUiComponentsRiceDialogRiceDialog.setup(props as GenUniModulesRiceUiComponentsRiceDialogRiceDialog)
    }
    )
}
, fun(instance, renderer): GenUniModulesRiceUiComponentsRiceDialogRiceDialog {
    return GenUniModulesRiceUiComponentsRiceDialogRiceDialog(instance)
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
    enableStyleIsolation()
    definePageRoutes()
    defineAppConfig()
    (createApp()["app"] as VueApp).mount(app, GenUniApp())
}
open class UniAppConfig : io.dcloud.uniapp.appframe.AppConfig {
    override var name: String = "uniapp-readbook"
    override var appid: String = "__UNI__194B5B1"
    override var versionName: String = "1.0.0"
    override var versionCode: String = "100"
    override var uniCompilerVersion: String = "5.13"
    constructor() : super() {}
}
fun definePageRoutes() {
    __uniRoutes.push(UniPageRoute(path = "pages/bookcase/index", component = GenPagesBookcaseIndexClass, meta = UniPageMeta(isQuit = true), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/library/index", component = GenPagesLibraryIndexClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/discuss/index", component = GenPagesDiscussIndexClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/discuss-detail/index", component = GenPagesDiscussDetailIndexClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/discuss-issue/index", component = GenPagesDiscussIssueIndexClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/discuss-issue/link-page", component = GenPagesDiscussIssueLinkPageClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/mine/index", component = GenPagesMineIndexClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/search/index", component = GenPagesSearchIndexClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/setting/index", component = GenPagesSettingIndexClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/feedback/index", component = GenPagesFeedbackIndexClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/explanation/index", component = GenPagesExplanationIndexClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
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
    __uniConfig.globalStyle = _uM("backgroundColorContent" to "@globalStyleBackgroundColor", "navigationBarTextStyle" to "@globalStyleNavigationBarTextStyle", "navigationStyle" to "custom")
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
    __uniConfig.themeConfig = _uM("light" to _uM("tabBarColor" to "#2c2c2c", "tabBarSelectedColor" to "#d81e06", "tabBarBorderStyle" to "black", "tabBarBackgroundColor" to "#f5f5f5", "tabBarIconPath1" to "static/image/wap-home-o.png", "tabBarSelectedIconPath1" to "static/image/wap-home.png", "tabBarIconPath2" to "static/image/browsing-history-o.png", "tabBarSelectedIconPath2" to "static/image/browsing-history.png", "tabBarIconPath3" to "static/image/comment-o.png", "tabBarSelectedIconPath3" to "static/image/comment.png", "tabBarIconPath4" to "static/image/manager-o.png", "tabBarSelectedIconPath4" to "static/image/manager.png", "globalStyleBackgroundColor" to "#f5f5f5", "globalStyleNavigationBarTextStyle" to "black"), "dark" to _uM("tabBarColor" to "#e6e6e6", "tabBarSelectedColor" to "#d81e06", "tabBarBorderStyle" to "white", "tabBarBackgroundColor" to "#181818", "tabBarIconPath1" to "static/image/wap-home-w.png", "tabBarSelectedIconPath1" to "static/image/wap-home.png", "tabBarIconPath2" to "static/image/browsing-history-w.png", "tabBarSelectedIconPath2" to "static/image/browsing-history.png", "tabBarIconPath3" to "static/image/comment-w.png", "tabBarSelectedIconPath3" to "static/image/comment.png", "tabBarIconPath4" to "static/image/manager-w.png", "tabBarSelectedIconPath4" to "static/image/manager.png", "globalStyleBackgroundColor" to "#181818", "globalStyleNavigationBarTextStyle" to "white"))
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
