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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
open class GenUniModulesRiceUiComponentsRiceNavbarRiceNavbar : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var title: String? by `$props`
    open var titleSize: Any? by `$props`
    open var titleColor: String? by `$props`
    open var titleWidth: Any? by `$props`
    open var fixed: Boolean by `$props`
    open var placeholder: Boolean by `$props`
    open var border: Boolean by `$props`
    open var leftArrow: Boolean by `$props`
    open var leftIcon: String by `$props`
    open var leftIconSize: Any by `$props`
    open var leftIconColor: String? by `$props`
    open var leftText: String? by `$props`
    open var leftTextColor: String? by `$props`
    open var rightText: String? by `$props`
    open var rightTextColor: String? by `$props`
    open var zIndex: Number? by `$props`
    open var bgColor: String? by `$props`
    open var safeAreaInsetTop: Boolean by `$props`
    open var height: Any by `$props`
    open var autoBack: Boolean by `$props`
    open var customStyle: UTSJSONObject by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesRiceUiComponentsRiceNavbarRiceNavbar) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesRiceUiComponentsRiceNavbarRiceNavbar
            val _cache = __ins.renderCache
            val slot = useSlots()
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val ns = useNamespace("navbar")
            val props = __props
            val hasLeft = computed(fun(): Boolean {
                return slot["left"] != null || props.leftArrow || hasStrValue(props.leftText)
            }
            )
            val hasRight = computed(fun(): Boolean {
                return slot["right"] != null || hasStrValue(props.rightText)
            }
            )
            val statusBarHeight = ref(0)
            val clickLeft = fun(e: UniPointerEvent){
                if (slot["left"] != null) {
                    return
                }
                e.stopPropagation()
                if (props.autoBack) {
                    uni_navigateBack(null)
                }
                emit("clickLeft")
            }
            val clickRight = fun(e: UniPointerEvent){
                if (slot["right"] != null) {
                    return
                }
                e.stopPropagation()
                emit("clickRight")
            }
            val arrowColor = computed<String>(fun(): String {
                if (hasStrValue(props.leftIconColor)) {
                    return props.leftIconColor!!
                }
                return if (!isDark.value) {
                    "#323233"
                } else {
                    "#f5f5f5"
                }
            }
            )
            val navbarHeight = computed(fun(): String {
                var height = getPxNum(props.height)
                if (props.safeAreaInsetTop) {
                    height += statusBarHeight.value
                }
                return height + "px"
            }
            )
            val centerStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (props.titleWidth != null) {
                    css.set("width", addUnit(props.titleWidth!!))
                }
                return css
            }
            )
            val navbarStyle = computed(fun(): Map<String, Any> {
                val css = Map<String, Any>()
                if (hasStrValue(props.bgColor)) {
                    css.set("background", props.bgColor!!)
                }
                if (props.fixed && props.zIndex != null) {
                    css.set("z-index", props.zIndex!!)
                }
                css.set("height", addUnit(props.height!!))
                return css
            }
            )
            val leftTextStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (hasStrValue(props.leftTextColor)) {
                    css.set("color", props.leftTextColor!!)
                }
                return css
            }
            )
            val rightTextStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (hasStrValue(props.rightTextColor)) {
                    css.set("color", props.rightTextColor!!)
                }
                return css
            }
            )
            val titleTextStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (hasStrValue(props.titleColor)) {
                    css.set("color", props.titleColor!!)
                }
                if (props.titleSize != null) {
                    css.set("font-size", addUnit(props.titleSize!!))
                }
                return css
            }
            )
            val navbarClass = computed(fun(): UTSArray<String> {
                return _uA(
                    ns.b(""),
                    ns.theme(),
                    ns.`is`("fixed", props.fixed),
                    ns.`is`("safearea-top", props.safeAreaInsetTop),
                    ns.`is`("border", props.border)
                )
            }
            )
            onMounted(fun(){
                val windowInfo = uni_getWindowInfo()
                statusBarHeight.value = windowInfo.statusBarHeight
            }
            )
            return fun(): Any? {
                val _component_rice_icon = resolveEasyComponent("rice-icon", GenUniModulesRiceUiComponentsRiceIconRiceIconClass)
                return _cE(Fragment, null, _uA(
                    if (isTrue(_ctx.fixed && _ctx.placeholder)) {
                        _cE("view", _uM("key" to 0, "class" to "rice-navbar--placeholder", "style" to _nS(_uM("height" to unref(navbarHeight)))), null, 4)
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("view", _uM("class" to _nC(unref(navbarClass)), "style" to _nS(unref(navbarStyle))), _uA(
                        if (isTrue(unref(hasLeft))) {
                            _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                                "rice-navbar__aside rice-navbar__left",
                                _uM("rice-navbar__aside--safearea-top" to _ctx.safeAreaInsetTop)
                            )), "onClick" to withModifiers(clickLeft, _uA(
                                "stop"
                            ))), _uA(
                                renderSlot(_ctx.`$slots`, "left", UTSJSONObject(), fun(): UTSArray<Any> {
                                    return _uA(
                                        if (isTrue(_ctx.leftArrow)) {
                                            _cV(_component_rice_icon, _uM("key" to 0, "name" to _ctx.leftIcon, "size" to _ctx.leftIconSize, "color" to unref(arrowColor)), null, 8, _uA(
                                                "name",
                                                "size",
                                                "color"
                                            ))
                                        } else {
                                            _cC("v-if", true)
                                        },
                                        if (isTrue(unref(hasStrValue)(_ctx.leftText))) {
                                            _cE("text", _uM("key" to 1, "style" to _nS(unref(leftTextStyle)), "class" to "rice-navbar__aside__text"), _tD(_ctx.leftText), 5)
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    )
                                })
                            ), 2)
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("view", _uM("class" to _nC(_uA(
                            "rice-navbar__center",
                            _uM("rice-navbar__center--has-right" to (unref(hasRight) && _ctx.safeAreaInsetTop))
                        )), "style" to _nS(unref(centerStyle))), _uA(
                            renderSlot(_ctx.`$slots`, "title", UTSJSONObject(), fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("text", _uM("class" to "rice-navbar__title", "style" to _nS(unref(titleTextStyle))), _tD(_ctx.title), 5)
                                )
                            }
                            )
                        ), 6),
                        if (isTrue(unref(hasRight))) {
                            _cE("view", _uM("key" to 1, "class" to _nC(_uA(
                                "rice-navbar__aside rice-navbar__right",
                                _uM("rice-navbar__aside--safearea-top" to _ctx.safeAreaInsetTop)
                            )), "onClick" to withModifiers(clickRight, _uA(
                                "stop"
                            ))), _uA(
                                renderSlot(_ctx.`$slots`, "right", UTSJSONObject(), fun(): UTSArray<Any> {
                                    return _uA(
                                        if (isTrue(unref(hasStrValue)(_ctx.rightText))) {
                                            _cE("text", _uM("key" to 0, "class" to "rice-navbar__aside__text", "style" to _nS(unref(rightTextStyle))), _tD(_ctx.rightText), 5)
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    )
                                })
                            ), 2)
                        } else {
                            _cC("v-if", true)
                        }
                    ), 6)
                ), 64)
            }
        }
        var name = "rice-navbar"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("rice-navbar" to _pS(_uM("position" to "relative", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "backgroundColor" to "var(--rice-navbar-background)", "height" to 44, "boxSizing" to "content-box", "width" to "100%")), "rice-navbar--fixed" to _pS(_uM("position" to "fixed", "left" to 0, "right" to 0, "top" to 0, "width" to "100%", "zIndex" to 998)), "rice-navbar--placeholder" to _pS(_uM("width" to "100%")), "rice-navbar--border" to _pS(_uM("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "var(--rice-border-color)")), "rice-navbar--safearea-top" to _pS(_uM("paddingTop" to CSS_VAR_STATUS_BAR_HEIGHT)), "rice-navbar__aside" to _pS(_uM("position" to "absolute", "bottom" to 0, "top" to 0, "paddingTop" to 0, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10, "flexDirection" to "row", "alignItems" to "center")), "rice-navbar__aside--safearea-top" to _pS(_uM("top" to CSS_VAR_STATUS_BAR_HEIGHT)), "rice-navbar__aside__text" to _pS(_uM("fontSize" to "var(--rice-font-size-sm)", "color" to "var(--rice-text-color)")), "rice-navbar__left" to _pS(_uM("left" to 0)), "rice-navbar__right" to _pS(_uM("right" to 0)), "rice-navbar__center" to _pS(_uM("alignItems" to "center", "paddingTop" to 0, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10, "boxSizing" to "border-box", "width" to "70%")), "rice-navbar__title" to _pS(_uM("width" to "100%", "fontSize" to "var(--rice-font-size-md)", "color" to "var(--rice-text-color)", "fontWeight" to "bold", "textAlign" to "center", "whiteSpace" to "nowrap", "textOverflow" to "ellipsis")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("clickLeft" to null, "clickRight" to null)
        var props = _nP(_uM("title" to _uM("type" to "String", "required" to false), "titleSize" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "titleColor" to _uM("type" to "String", "required" to false), "titleWidth" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "fixed" to _uM("type" to "Boolean", "required" to false, "default" to true), "placeholder" to _uM("type" to "Boolean", "required" to false, "default" to true), "border" to _uM("type" to "Boolean", "required" to false, "default" to false), "leftArrow" to _uM("type" to "Boolean", "required" to false, "default" to true), "leftIcon" to _uM("type" to "String", "required" to false, "default" to "arrow-left"), "leftIconSize" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false, "default" to "20px"), "leftIconColor" to _uM("type" to "String", "required" to false), "leftText" to _uM("type" to "String", "required" to false), "leftTextColor" to _uM("type" to "String", "required" to false), "rightText" to _uM("type" to "String", "required" to false), "rightTextColor" to _uM("type" to "String", "required" to false), "zIndex" to _uM("type" to "Number", "required" to false), "bgColor" to _uM("type" to "String", "required" to false), "safeAreaInsetTop" to _uM("type" to "Boolean", "required" to false, "default" to true), "height" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false, "default" to "44px"), "autoBack" to _uM("type" to "Boolean", "required" to false, "default" to true), "customStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        )))
        var propsNeedCastKeys = _uA(
            "fixed",
            "placeholder",
            "border",
            "leftArrow",
            "leftIcon",
            "leftIconSize",
            "safeAreaInsetTop",
            "height",
            "autoBack",
            "customStyle"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
