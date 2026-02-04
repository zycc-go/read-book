@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNIuniappx
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
open class GenUniModulesRiceUiComponentsRicePopupRicePopup : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var duration: Number by `$props`
    open var position: String by `$props`
    open var zIndex: Number by `$props`
    open var opacity: Boolean by `$props`
    open var zoom: Boolean by `$props`
    open var overlay: Boolean by `$props`
    open var overlayBgColor: String? by `$props`
    open var closeable: Boolean by `$props`
    open var closeIcon: String by `$props`
    open var closeIconPosition: String by `$props`
    open var closeOnClickOverlay: Boolean by `$props`
    open var radius: Any? by `$props`
    open var bgColor: String? by `$props`
    open var safeAreaInsetTop: Boolean by `$props`
    open var safeAreaInsetBottom: Boolean by `$props`
    open var beforeClose: Any? by `$props`
    open var marginTop: Any? by `$props`
    open var customStyle: UTSJSONObject by `$props`
    open var show: Boolean by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesRiceUiComponentsRicePopupRicePopup) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesRiceUiComponentsRicePopupRicePopup
            val _cache = __ins.renderCache
            val ns = useNamespace("popup")
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val show = useModel<Boolean>(__ins.props, "show")
            val _useSafeArea = useSafeArea()
            val safeTop = _useSafeArea.safeTop
            val safeBottom = _useSafeArea.safeBottom
            val popupRef = shallowRef<UniElement?>(null)
            val _usePopup = usePopup(popupRef, UsePopupOptions(show = show, duration = toRef<Number>(fun(): Number {
                return props.duration
            }
            ), position = toRef<String>(fun(): String {
                return props.position
            }
            ), opacity = toRef<Boolean>(fun(): Boolean {
                return props.opacity
            }
            ), zoom = toRef<Boolean>(fun(): Boolean {
                return props.zoom
            }
            ), beforeClose = toRef<BeforeChangeInterceptor?>(fun(): BeforeChangeInterceptor? {
                return props.beforeClose as BeforeChangeInterceptor?
            }
            )))
            val realShow = _usePopup.realShow
            val doClose = _usePopup.doClose
            val overlayClick = fun(){
                emit("clickOverlay")
                if (!props.closeOnClickOverlay) {
                    return
                }
                doClose()
            }
            val handleClose = fun(e: UniPointerEvent){
                e.stopPropagation()
                doClose()
            }
            val popupStyle = computed(fun(): Map<String, Any> {
                val css = Map<String, Any>()
                css.set("z-index", props.zIndex)
                css.set("transition-duration", props.duration + "ms")
                if (props.bgColor != null) {
                    css.set("background-color", props.bgColor!!)
                }
                val position = props.position
                val radius = if (props.radius != null) {
                    addUnit(props.radius!!)
                } else {
                    "0px"
                }
                if (position == "top") {
                    css.set("border-bottom-left-radius", radius)
                    css.set("border-bottom-right-radius", radius)
                    if (props.safeAreaInsetTop) {
                        css.set("padding-top", safeTop.value + "px")
                    }
                } else if (position == "bottom") {
                    css.set("border-top-left-radius", radius)
                    css.set("border-top-right-radius", radius)
                    if (props.safeAreaInsetBottom) {
                        css.set("padding-bottom", safeBottom.value + "px")
                    }
                } else if (position == "left") {
                    css.set("border-top-right-radius", radius)
                    css.set("border-bottom-right-radius", radius)
                    if (props.safeAreaInsetBottom) {
                        css.set("padding-bottom", safeBottom.value + "px")
                    }
                    if (props.safeAreaInsetTop) {
                        css.set("padding-top", safeTop.value + "px")
                    }
                } else if (position == "right") {
                    css.set("border-top-left-radius", radius)
                    css.set("border-bottom-left-radius", radius)
                    if (props.safeAreaInsetBottom) {
                        css.set("padding-bottom", safeBottom.value + "px")
                    }
                    if (props.safeAreaInsetTop) {
                        css.set("padding-top", safeTop.value + "px")
                    }
                } else {
                    css.set("border-radius", radius)
                    if (props.marginTop != null) {
                        css.set("margin-top", addUnit(props.marginTop!!))
                    }
                }
                return css
            }
            )
            val popupClass = computed(fun(): UTSArray<String> {
                return _uA(
                    ns.b(""),
                    ns.theme(),
                    ns.m(props.position),
                    ns.`is`("opacity", props.opacity),
                    ns.`is`("zoom", props.zoom && props.position == "center")
                )
            }
            )
            val closeClass = computed(fun(): UTSArray<String> {
                return _uA(
                    ns.e("close"),
                    ns.m("close--" + props.closeIconPosition)
                )
            }
            )
            val closeIconStyle = computed(fun(): UTSJSONObject {
                val basic: UTSJSONObject = object : UTSJSONObject(UTSSourceMapPosition("basic", "uni_modules/rice-ui/components/rice-popup/rice-popup.uvue", 157, 9)) {
                    var position = "absolute"
                    var zIndex: Number = 9
                }
                val gap = "16px"
                val closeIconPosition = props.closeIconPosition
                if (closeIconPosition == "top-right") {
                    basic["top"] = gap
                    basic["right"] = gap
                } else if (closeIconPosition == "top-left") {
                    basic["top"] = gap
                    basic["left"] = gap
                } else if (closeIconPosition == "bottom-left") {
                    basic["bottom"] = gap
                    basic["left"] = gap
                } else if (closeIconPosition == "bottom-right") {
                    basic["bottom"] = gap
                    basic["right"] = gap
                }
                return basic
            }
            )
            return fun(): Any? {
                val _component_rice_overlay = resolveEasyComponent("rice-overlay", GenUniModulesRiceUiComponentsRiceOverlayRiceOverlayClass)
                val _component_rice_icon = resolveEasyComponent("rice-icon", GenUniModulesRiceUiComponentsRiceIconRiceIconClass)
                return _cE(Fragment, null, _uA(
                    if (isTrue(_ctx.overlay)) {
                        _cV(_component_rice_overlay, _uM("key" to 0, "show" to show.value, "bg-color" to _ctx.overlayBgColor, "duration" to _ctx.duration, "z-index" to (_ctx.zIndex - 1), "close-on-click-overlay" to false, "onClick" to overlayClick), null, 8, _uA(
                            "show",
                            "bg-color",
                            "duration",
                            "z-index"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    if (isTrue(unref(realShow))) {
                        _cE("view", _uM("key" to 1, "class" to _nC(unref(popupClass)), "style" to _nS(_uA(
                            unref(popupStyle),
                            _ctx.customStyle
                        )), "ref_key" to "popupRef", "ref" to popupRef), _uA(
                            if (isTrue(_ctx.closeable)) {
                                _cV(_component_rice_icon, _uM("key" to 0, "name" to _ctx.closeIcon, "custom-style" to unref(closeIconStyle), "size" to "20px", "onClick" to handleClose), null, 8, _uA(
                                    "name",
                                    "custom-style"
                                ))
                            } else {
                                _cC("v-if", true)
                            },
                            renderSlot(_ctx.`$slots`, "default")
                        ), 6)
                    } else {
                        _cC("v-if", true)
                    }
                ), 64)
            }
        }
        var name = "rice-popup"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("rice-popup" to _pS(_uM("position" to "fixed", "transitionProperty" to "transform,opacity", "transitionDuration" to "300ms", "transform" to "translate(0, 0) scale(1)", "backgroundColor" to "var(--rice-background-2)")), "rice-popup--opacity" to _pS(_uM("opacity" to 0)), "rice-popup--center" to _pS(_uM("top" to "50%", "left" to "50%", "transform" to "translate(-50%, -50%)")), "rice-popup--zoom" to _pS(_uM("transform" to "translate(-50%, -50%) scale(0.6)")), "rice-popup--top" to _pS(_uM("top" to 0, "left" to 0, "width" to "100%", "transform" to "translate(0, -100%)")), "rice-popup--bottom" to _pS(_uM("bottom" to 0, "left" to 0, "width" to "100%", "transform" to "translate(0px, 100%)")), "rice-popup--left" to _pS(_uM("top" to 0, "bottom" to 0, "left" to 0, "transform" to "translate(-100%, 0)")), "rice-popup--right" to _pS(_uM("top" to 0, "bottom" to 0, "right" to 0, "transform" to "translate(100%, 0)")), "rice-popup__close" to _pS(_uM("position" to "absolute")), "rice-popup__close--top-right" to _pS(_uM("top" to 16, "right" to 16)), "@TRANSITION" to _uM("rice-popup" to _uM("property" to "transform,opacity", "duration" to "300ms")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("open" to null, "close" to null, "opened" to null, "closed" to null, "clickOverlay" to null, "update:show" to null)
        var props = _nP(_uM("duration" to _uM("type" to "Number", "required" to false, "default" to 300), "position" to _uM("type" to "String", "required" to false, "default" to "bottom"), "zIndex" to _uM("type" to "Number", "required" to false, "default" to 999), "opacity" to _uM("type" to "Boolean", "required" to false, "default" to true), "zoom" to _uM("type" to "Boolean", "required" to false, "default" to true), "overlay" to _uM("type" to "Boolean", "required" to false, "default" to true), "overlayBgColor" to _uM("type" to "String", "required" to false), "closeable" to _uM("type" to "Boolean", "required" to false, "default" to true), "closeIcon" to _uM("type" to "String", "required" to false, "default" to "cross"), "closeIconPosition" to _uM("type" to "String", "required" to false, "default" to "top-right"), "closeOnClickOverlay" to _uM("type" to "Boolean", "required" to false, "default" to true), "radius" to _uM("type" to _uA(
            "Number",
            "String"
        ), "required" to false), "bgColor" to _uM("type" to "String", "required" to false), "safeAreaInsetTop" to _uM("type" to "Boolean", "required" to false, "default" to false), "safeAreaInsetBottom" to _uM("type" to "Boolean", "required" to false, "default" to true), "beforeClose" to _uM("required" to false), "marginTop" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "customStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "show" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "duration",
            "position",
            "zIndex",
            "opacity",
            "zoom",
            "overlay",
            "closeable",
            "closeIcon",
            "closeIconPosition",
            "closeOnClickOverlay",
            "safeAreaInsetTop",
            "safeAreaInsetBottom",
            "customStyle",
            "show"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
