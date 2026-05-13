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
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById
import io.dcloud.uniapp.extapi.pageScrollTo as uni_pageScrollTo
open class GenUniModulesRiceUiComponentsRiceBackTopRiceBackTop : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var mode: String by `$props`
    open var parentId: String? by `$props`
    open var scrollTop: Number? by `$props`
    open var offset: Number by `$props`
    open var right: Any? by `$props`
    open var bottom: Any? by `$props`
    open var duration: Number by `$props`
    open var icon: String by `$props`
    open var iconSize: Any? by `$props`
    open var text: String? by `$props`
    open var textSize: Any? by `$props`
    open var textColor: String? by `$props`
    open var width: Any? by `$props`
    open var height: Any? by `$props`
    open var radius: Any? by `$props`
    open var bgColor: String? by `$props`
    open var zoom: Boolean by `$props`
    open var zIndex: Number? by `$props`
    open var customStyle: UTSJSONObject by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesRiceUiComponentsRiceBackTopRiceBackTop) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesRiceUiComponentsRiceBackTopRiceBackTop
            val _cache = __ins.renderCache
            val ns = useNamespace("back-top")
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val _scrollTop = ref(0)
            val backTopRef = shallowRef<UniElement?>(null)
            val isShow = computed(fun(): Boolean {
                return _scrollTop.value >= props.offset
            }
            )
            val backToTop = fun(e: UniPointerEvent){
                if (hasStrValue(props.parentId)) {
                    val el = uni_getElementById(props.parentId!!)
                    if (el != null) {
                        el.scrollTop = _scrollTop.value
                        nextTick(fun(){
                            el.scrollTop = 0
                        }
                        )
                    }
                } else {
                    uni_pageScrollTo(PageScrollToOptions(scrollTop = 0, duration = props.duration))
                }
                emit("click", e)
            }
            onPageScroll(fun(e){
                _scrollTop.value = e.scrollTop
            }
            )
            val _iconSize = computed(fun(): Any {
                if (props.iconSize != null) {
                    return props.iconSize!!
                }
                return if (hasStrValue(props.text)) {
                    "20px"
                } else {
                    "24px"
                }
            }
            )
            val backTopStyle = computed(fun(): Map<String, Any> {
                val css = Map<String, Any>()
                if (props.zIndex != null) {
                    css.set("z-index", props.zIndex!!)
                }
                if (props.bottom != null) {
                    css.set("bottom", addUnit(props.bottom!!))
                }
                if (props.right != null) {
                    css.set("right", addUnit(props.right!!))
                }
                if (hasStrValue(props.bgColor)) {
                    css.set("background", props.bgColor!!)
                    css.set("border-color", props.bgColor!!)
                }
                if (props.height != null) {
                    css.set("height", props.height!!)
                }
                if (props.width != null) {
                    css.set("width", props.width!!)
                }
                if (props.radius != null) {
                    css.set("border-radius", props.radius!!)
                } else if (props.mode == "half-round") {
                    css.set("border-radius", "999px 0 0 999px")
                } else {
                    css.set("border-radius", "999px")
                }
                return css
            }
            )
            val _textColor = computed(fun(): String {
                if (hasStrValue(props.textColor)) {
                    return props.textColor!!
                }
                return ""
            }
            )
            val textStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (hasStrValue(props.textColor)) {
                    css.set("color", props.textColor!!)
                }
                if (props.textSize != null) {
                    css.set("font-size", addUnit(props.textSize!!))
                }
                return css
            }
            )
            val backTopCss = computed(fun(): UTSArray<String> {
                val mode = if (_uA(
                    "round",
                    "half-round"
                ).includes(props.mode)) {
                    props.mode
                } else {
                    "round"
                }
                return _uA(
                    ns.b(""),
                    ns.theme(),
                    ns.m(mode),
                    ns.`is`("zoom", props.zoom),
                    ns.`is`("show", isShow.value)
                )
            }
            )
            return fun(): Any? {
                val _component_rice_icon = resolveEasyComponent("rice-icon", GenUniModulesRiceUiComponentsRiceIconRiceIconClass)
                return _cE("view", _uM("class" to _nC(unref(backTopCss)), "style" to _nS(_uA(
                    unref(backTopStyle),
                    _ctx.customStyle
                )), "ref_key" to "backTopRef", "ref" to backTopRef, "onClick" to backToTop), _uA(
                    renderSlot(_ctx.`$slots`, "default", _uO(), fun(): UTSArray<Any> {
                        return _uA(
                            if (isTrue(unref(hasStrValue)(_ctx.icon))) {
                                _cV(_component_rice_icon, _uM("key" to 0, "name" to _ctx.icon, "size" to unref(_iconSize), "color" to unref(_textColor), "bold" to ""), null, 8, _uA(
                                    "name",
                                    "size",
                                    "color"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (isTrue(unref(hasStrValue)(_ctx.text))) {
                                _cE("text", _uM("key" to 1, "class" to _nC(_uA(
                                    "rice-back-top__text",
                                    _uM("rice-back-top--half-round__text" to (_ctx.mode == "half-round"))
                                )), "style" to _nS(unref(textStyle))), _tD(_ctx.text), 7)
                            } else {
                                _cC("v-if", true)
                            }
                        )
                    }
                    )
                ), 6)
            }
        }
        var name = "rice-back-top"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("rice-back-top" to _pS(_uM("position" to "fixed", "alignItems" to "center", "justifyContent" to "center", "opacity" to 0, "zIndex" to 998, "transitionProperty" to "transform,opacity", "transitionDuration" to "0.3s", "transitionTimingFunction" to "cubic-bezier(0.25,0.8,0.5,1)", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "var(--rice-border-color)", "borderRightColor" to "var(--rice-border-color)", "borderBottomColor" to "var(--rice-border-color)", "borderLeftColor" to "var(--rice-border-color)", "bottom" to 100, "right" to 20, "backgroundColor" to "var(--rice-back-top-background)")), "rice-back-top--round" to _pS(_uM("right" to 20, "height" to 48, "width" to 48)), "rice-back-top--half-round" to _pS(_uM("flexDirection" to "row", "right" to 0, "width" to 64, "height" to 40)), "rice-back-top--half-round__text" to _pS(_uM("width" to 25, "marginLeft" to 2)), "rice-back-top--zoom" to _pS(_uM("transform" to "scale(0)")), "rice-back-top--show" to _pS(_uM("transform" to "scale(1)", "opacity" to 1)), "rice-back-top__text" to _pS(_uM("color" to "var(--rice-text-color)", "fontSize" to 10)), "rice-icon" to _uM(".rice-back-top " to _uM("color" to "var(--rice-text-color)")), "@TRANSITION" to _uM("rice-back-top" to _uM("property" to "transform,opacity", "duration" to "0.3s", "timingFunction" to "cubic-bezier(0.25,0.8,0.5,1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null)
        var props = _nP(_uM("mode" to _uM("type" to "String", "required" to false, "default" to "round"), "parentId" to _uM("type" to "String", "required" to false), "scrollTop" to _uM("type" to "Number", "required" to false), "offset" to _uM("type" to "Number", "required" to false, "default" to 200), "right" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "bottom" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "duration" to _uM("type" to "Number", "required" to false, "default" to 300), "icon" to _uM("type" to "String", "required" to false, "default" to "back-top"), "iconSize" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "text" to _uM("type" to "String", "required" to false), "textSize" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "textColor" to _uM("type" to "String", "required" to false), "width" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "height" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "radius" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "bgColor" to _uM("type" to "String", "required" to false), "zoom" to _uM("type" to "Boolean", "required" to false, "default" to true), "zIndex" to _uM("type" to "Number", "required" to false), "customStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (_uO())
        }
        )))
        var propsNeedCastKeys = _uA(
            "mode",
            "offset",
            "duration",
            "icon",
            "zoom",
            "customStyle"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
