@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
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
open class GenUniModulesRiceUiComponentsRiceNoticeBarRiceNoticeBar : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var type: String by `$props`
    open var message: String? by `$props`
    open var color: String? by `$props`
    open var fontSize: Any? by `$props`
    open var bgColor: String? by `$props`
    open var leftIcon: String? by `$props`
    open var rightIcon: String? by `$props`
    open var delay: Number? by `$props`
    open var speed: Number by `$props`
    open var closeable: Boolean by `$props`
    open var scrollable: Boolean? by `$props`
    open var wrapable: Boolean? by `$props`
    open var customStyle: UTSJSONObject by `$props`
    open var reset: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["reset"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "reset", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesRiceUiComponentsRiceNoticeBarRiceNoticeBar, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesRiceUiComponentsRiceNoticeBarRiceNoticeBar
            val _cache = __ins.renderCache
            val ns = useNamespace("notice-bar")
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val state = reactive<NoticeBarState>(NoticeBarState(show = true, offset = 0, duration = 0, wrapWidth = 0, contentWidth = 0))
            var startTimer: Number? = null
            var endTimer: Number? = null
            var transitionTimer: Number? = null
            val wrapperRef = shallowRef<UniElement?>(null)
            val contentRef = shallowRef<UniElement?>(null)
            val startSleep = fun(): UTSPromise<*> {
                return UTSPromise(fun(resolve, _reject){
                    val ms = props.delay ?: 0.3
                    if (startTimer != null) {
                        clearTimeout(startTimer!!)
                    }
                    startTimer = setTimeout(fun(){
                        resolve(true)
                    }
                    , ms * 1000)
                }
                )
            }
            val reset = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w1@{
                        await(nextTick())
                        if (startTimer != null) {
                            clearTimeout(startTimer!!)
                        }
                        await(startSleep())
                        if (wrapperRef.value == null || contentRef.value == null) {
                            return@w1
                        }
                        state.duration = 0
                        state.offset = 0
                        val wrapperRet = await(wrapperRef.value!!.getBoundingClientRectAsync()!!)
                        val contentRet = await(contentRef.value!!.getBoundingClientRectAsync()!!)
                        val wrapperWidth = wrapperRet.width
                        val contentWidth = contentRet.width
                        if ((props.scrollable == true || contentWidth > wrapperWidth) && props.wrapable == false) {
                            if (transitionTimer != null) {
                                clearTimeout(transitionTimer!!)
                            }
                            transitionTimer = setTimeout(fun(){
                                state.wrapWidth = wrapperWidth
                                state.contentWidth = contentWidth
                                state.offset = -contentWidth
                                state.duration = contentWidth / props.speed
                            }
                            , 50)
                        }
                })
            }
            val onTransitionend = fun(){
                state.duration = 0
                state.offset = state.wrapWidth
                if (endTimer != null) {
                    clearTimeout(endTimer!!)
                }
                endTimer = setTimeout(fun(){
                    state.duration = (state.contentWidth + state.wrapWidth) / props.speed
                    state.offset = -state.contentWidth
                }
                , 50)
            }
            val handleClick = fun(){
                emit("click")
            }
            val clickLeft = fun(){
                emit("clickLeft")
            }
            val clickRight = fun(){
                emit("clickRight")
            }
            val handleClose = fun(){
                state.show = false
            }
            watch(fun(): UTSArray<Any?> {
                return _uA(
                    props.message,
                    props.scrollable
                )
            }
            , fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        await(nextTick())
                        console.log("ios change", " at uni_modules/rice-ui/components/rice-notice-bar/rice-notice-bar.uvue:149")
                        reset()
                })
            }
            , WatchOptions(deep = true))
            val noticeBarStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (hasStrValue(props.bgColor)) {
                    css.set("background-color", props.bgColor!!)
                }
                return css
            }
            )
            val contentStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (state.offset != 0) {
                    css.set("transform", "translateX(" + state.offset + "px)")
                }
                css.set("transition-duration", "" + state.duration + "s")
                if (hasStrValue(props.color)) {
                    css.set("color", props.color!!)
                }
                if (props.fontSize != null) {
                    css.set("font-size", addUnit(props.fontSize!!))
                }
                return css
            }
            )
            val noticeBarType = computed(fun(): String {
                return if (isThemeColor(props.type)) {
                    props.type
                } else {
                    "warning"
                }
            }
            )
            val noticeBarClass = computed(fun(): UTSArray<String> {
                return _uA(
                    ns.b(""),
                    ns.theme(),
                    ns.m(noticeBarType.value),
                    ns.`is`("wrapable", props.wrapable == true)
                )
            }
            )
            val contentClass = computed(fun(): UTSArray<String> {
                val ellipsis = props.scrollable == false && props.wrapable == false
                return _uA(
                    ns.e("content"),
                    ns.`is`("__content--wrapable", props.wrapable == true),
                    ns.`is`("__content--ellipsis", ellipsis),
                    ns.e("content--" + noticeBarType.value)
                )
            }
            )
            val iconColor = computed<String>(fun(): String {
                return if (hasStrValue(props.color)) {
                    props.color!!
                } else {
                    ""
                }
            }
            )
            val iconClass = computed(fun(): String {
                return ns.e("content--" + noticeBarType.value)
            }
            )
            onMounted(fun(){
                reset()
            }
            )
            __expose(_uM("reset" to reset))
            return fun(): Any? {
                val _component_rice_icon = resolveEasyComponent("rice-icon", GenUniModulesRiceUiComponentsRiceIconRiceIconClass)
                return if (isTrue(unref(state).show)) {
                    _cE("view", _uM("key" to 0, "class" to _nC(unref(noticeBarClass)), "style" to _nS(_uA(
                        unref(noticeBarStyle),
                        _ctx.customStyle
                    ))), _uA(
                        renderSlot(_ctx.`$slots`, "leftIcon", _uO(), fun(): UTSArray<Any> {
                            return _uA(
                                if (isTrue(unref(hasStrValue)(_ctx.leftIcon))) {
                                    _cV(_component_rice_icon, _uM("key" to 0, "name" to _ctx.leftIcon, "color" to unref(iconColor), "custom-class" to unref(iconClass), "size" to "18px", "custom-style" to _uO("width" to "25px"), "onClick" to clickLeft), null, 8, _uA(
                                        "name",
                                        "color",
                                        "custom-class"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            )
                        }),
                        _cE("view", _uM("class" to "rice-notice-bar__wrapper", "ref_key" to "wrapperRef", "ref" to wrapperRef, "onClick" to handleClick), _uA(
                            _cE("text", _uM("class" to _nC(unref(contentClass)), "style" to _nS(unref(contentStyle)), "ref_key" to "contentRef", "ref" to contentRef, "onTransitionend" to onTransitionend), _tD(_ctx.message), 39)
                        ), 512),
                        renderSlot(_ctx.`$slots`, "rightIcon", _uO(), fun(): UTSArray<Any> {
                            return _uA(
                                if (isTrue(unref(hasStrValue)(_ctx.rightIcon))) {
                                    _cV(_component_rice_icon, _uM("key" to 0, "name" to _ctx.rightIcon, "custom-style" to _uO("width" to "25px", "textAlign" to "right"), "color" to unref(iconColor), "size" to "18px", "custom-class" to unref(iconClass), "onClick" to clickRight), null, 8, _uA(
                                        "name",
                                        "color",
                                        "custom-class"
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                            )
                        }),
                        if (isTrue(_ctx.closeable)) {
                            _cV(_component_rice_icon, _uM("key" to 0, "name" to "cross", "custom-style" to _uO("width" to "25px", "textAlign" to "right"), "color" to unref(iconColor), "custom-class" to unref(iconClass), "size" to "18px", "onClick" to handleClose), null, 8, _uA(
                                "color",
                                "custom-class"
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                    ), 6)
                } else {
                    _cC("v-if", true)
                }
            }
        }
        var name = "rice-notice-bar"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("rice-notice-bar" to _pS(_uM("position" to "relative", "flexDirection" to "row", "alignItems" to "center", "minHeight" to 45, "paddingTop" to 0, "paddingRight" to "var(--rice-padding-md)", "paddingBottom" to 0, "paddingLeft" to "var(--rice-padding-md)")), "rice-notice-bar--primary" to _pS(_uM("backgroundColor" to "var(--rice-primary-color-1)")), "rice-notice-bar--warning" to _pS(_uM("backgroundColor" to "var(--rice-warning-color-1)")), "rice-notice-bar--success" to _pS(_uM("backgroundColor" to "var(--rice-success-color-1)")), "rice-notice-bar--error" to _pS(_uM("backgroundColor" to "var(--rice-error-color-1)")), "rice-notice-bar__wrapper" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "flexDirection" to "row", "alignItems" to "center", "height" to "100%")), "rice-notice-bar__content" to _pS(_uM("position" to "absolute", "whiteSpace" to "nowrap", "transform" to "translateX(0px)", "transitionProperty" to "transform", "transitionTimingFunction" to "linear", "fontSize" to "var(--rice-font-size-basic)", "lineHeight" to 1.6)), "rice-notice-bar__content--wrapable" to _pS(_uM("position" to "relative", "whiteSpace" to "normal")), "rice-notice-bar__content--ellipsis" to _pS(_uM("textOverflow" to "ellipsis", "whiteSpace" to "nowrap", "width" to "100%")), "rice-notice-bar__content--primary" to _pS(_uM("color" to "var(--rice-primary-color)")), "rice-notice-bar__content--warning" to _pS(_uM("color" to "var(--rice-warning-color)")), "rice-notice-bar__content--success" to _pS(_uM("color" to "var(--rice-success-color)")), "rice-notice-bar__content--error" to _pS(_uM("color" to "var(--rice-error-color)")), "rice-notice-bar--wrapable" to _pS(_uM("paddingTop" to 14, "paddingRight" to "var(--rice-padding-md)", "paddingBottom" to 14, "paddingLeft" to "var(--rice-padding-md)")), "@TRANSITION" to _uM("rice-notice-bar__content" to _uM("property" to "transform", "timingFunction" to "linear")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null, "clickLeft" to null, "clickRight" to null)
        var props = _nP(_uM("type" to _uM("type" to "String", "required" to false, "default" to "warning"), "message" to _uM("type" to "String", "required" to false), "color" to _uM("type" to "String", "required" to false), "fontSize" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "bgColor" to _uM("type" to "String", "required" to false), "leftIcon" to _uM("type" to "String", "required" to false), "rightIcon" to _uM("type" to "String", "required" to false), "delay" to _uM("type" to "Number", "required" to false), "speed" to _uM("type" to "Number", "required" to false, "default" to 60), "closeable" to _uM("type" to "Boolean", "required" to false, "default" to false), "scrollable" to _uM("type" to "Boolean", "required" to false, "default" to null), "wrapable" to _uM("type" to "Boolean", "required" to false), "customStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (_uO())
        }
        )))
        var propsNeedCastKeys = _uA(
            "type",
            "speed",
            "closeable",
            "scrollable",
            "wrapable",
            "customStyle"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
