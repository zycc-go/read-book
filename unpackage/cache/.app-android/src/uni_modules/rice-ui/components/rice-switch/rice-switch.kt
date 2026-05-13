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
open class GenUniModulesRiceUiComponentsRiceSwitchRiceSwitch : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var activeValue: Any by `$props`
    open var inactiveValue: Any by `$props`
    open var loading: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var readonly: Boolean by `$props`
    open var width: Any? by `$props`
    open var iconSize: Any by `$props`
    open var textSize: Any? by `$props`
    open var activeColor: String? by `$props`
    open var inactiveColor: String? by `$props`
    open var activeText: Any? by `$props`
    open var inactiveText: Any? by `$props`
    open var activeIcon: Any? by `$props`
    open var inactiveIcon: Any? by `$props`
    open var promptPosition: String by `$props`
    open var beforeChange: Any? by `$props`
    open var vibrate: Boolean by `$props`
    open var customStyle: UTSJSONObject by `$props`
    open var modelValue: Any? by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesRiceUiComponentsRiceSwitchRiceSwitch) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesRiceUiComponentsRiceSwitchRiceSwitch
            val _cache = __ins.renderCache
            val ns = useNamespace("switch")
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val modelValue = useModel<SwitchValueType>(__ins.props, "modelValue")
            val formDisabled = inject<Ref<Boolean?>?>(formDisabledInjectKey, null)
            val formReadonly = inject<Ref<Boolean?>?>(formReadonlyInjectKey, null)
            val isDisabled = computed<Boolean>(fun(): Boolean {
                return (formDisabled?.value ?: false) || props.disabled
            }
            )
            val isReadonly = computed<Boolean>(fun(): Boolean {
                return (formReadonly?.value ?: false) || props.readonly
            }
            )
            val isChecked = computed(fun(): Boolean {
                return isSameValue(modelValue.value, props.activeValue)
            }
            )
            val hasText = computed(fun(): Boolean {
                return hasStrValue(props.activeText) || hasStrValue(props.inactiveText)
            }
            )
            val hasIcon = computed(fun(): Boolean {
                return hasStrValue(props.activeIcon) || hasStrValue(props.inactiveIcon)
            }
            )
            val showOutBall = computed(fun(): Boolean {
                return props.promptPosition == "outball" && (hasText.value || hasIcon.value)
            }
            )
            val showInsidePrompt = computed(fun(): Boolean {
                return props.promptPosition == "inball" && (hasText.value || hasIcon.value)
            }
            )
            val handleChange = fun(){
                val value = if (isChecked.value) {
                    props.inactiveValue
                } else {
                    props.activeValue
                }
                modelValue.value = value
                emit("change", value)
            }
            val changeValue = fun(e: UniPointerEvent){
                e.stopPropagation()
                if (isDisabled.value || isReadonly.value || props.loading) {
                    return
                }
                if (UTSAndroid.`typeof`(props.beforeChange) != "function") {
                    handleChange()
                    return
                }
                callInterceptor(props.beforeChange as BeforeChangeInterceptor, InterceptorOption(done = fun() {
                    handleChange()
                }
                ))
            }
            val switchRef = shallowRef<UniElement?>(null)
            val primaryColor = useCssVar("--rice-primary-color", switchRef)
            val switchBgColor = useCssVar("--rice-switch-background", switchRef)
            val switchColor = computed<String>(fun(): String {
                if (isChecked.value) {
                    return props.activeColor ?: primaryColor.value
                }
                return props.inactiveColor ?: switchBgColor.value
            }
            )
            val iconColor = computed(fun(): String {
                return switchColor.value
            }
            )
            val switchStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (switchColor.value != "") {
                    css.set("background-color", switchColor.value)
                }
                if (props.width != null) {
                    css.set("width", addUnit(props.width!!))
                }
                return css
            }
            )
            val innerTextStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (props.textSize != null) {
                    css.set("font-size", addUnit(props.textSize!!))
                }
                return css
            }
            )
            val nodeTextStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (props.textSize != null) {
                    css.set("font-size", addUnit(props.textSize!!))
                }
                if (switchColor.value != "") {
                    css.set("color", switchColor.value)
                }
                return css
            }
            )
            val nodeStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                val switchWidth = if (props.width != null) {
                    getPxNum(props.width!!)
                } else {
                    50
                }
                val nodeWidth: Number = 22
                val translateX = if (isChecked.value) {
                    "" + (switchWidth - nodeWidth - 4) + "px"
                } else {
                    "4px"
                }
                css.set("transform", "translateX(" + translateX + ")")
                return css
            }
            )
            val switchClass = computed(fun(): UTSArray<String> {
                return _uA(
                    ns.b(""),
                    ns.theme(),
                    ns.`is`("disabled", isDisabled.value),
                    ns.`is`("active", isChecked.value)
                )
            }
            )
            val innerClass = computed(fun(): UTSArray<String> {
                return _uA(
                    ns.e("inner"),
                    ns.`is`("__inner--active", isChecked.value)
                )
            }
            )
            val nodeClass = computed(fun(): UTSArray<String> {
                return _uA(
                    ns.e("node")
                )
            }
            )
            return fun(): Any? {
                val _component_rice_icon = resolveEasyComponent("rice-icon", GenUniModulesRiceUiComponentsRiceIconRiceIconClass)
                val _component_rice_loading = resolveEasyComponent("rice-loading", GenUniModulesRiceUiComponentsRiceLoadingRiceLoadingClass)
                return _cE("view", _uM("class" to _nC(unref(switchClass)), "style" to _nS(_uA(
                    unref(switchStyle),
                    _ctx.customStyle
                )), "ref_key" to "switchRef", "ref" to switchRef, "onClick" to withModifiers(changeValue, _uA(
                    "stop"
                ))), _uA(
                    if (isTrue(unref(showOutBall))) {
                        _cE("view", _uM("key" to 0, "class" to _nC(unref(innerClass))), _uA(
                            if (isTrue(unref(hasIcon))) {
                                _cV(_component_rice_icon, _uM("key" to 0, "name" to if (unref(isChecked)) {
                                    _ctx.activeIcon
                                } else {
                                    _ctx.inactiveIcon
                                }, "color" to "rgba(255,255,255,.9)", "size" to _ctx.iconSize), null, 8, _uA(
                                    "name",
                                    "size"
                                ))
                            } else {
                                if (isTrue(unref(hasText))) {
                                    _cE("text", _uM("key" to 1, "style" to _nS(unref(innerTextStyle)), "class" to "rice-switch__inner__text"), _tD(if (unref(isChecked)) {
                                        _ctx.activeText
                                    } else {
                                        _ctx.inactiveText
                                    }), 5)
                                } else {
                                    _cC("v-if", true)
                                }
                            }
                        ), 2)
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("view", _uM("class" to _nC(unref(nodeClass)), "style" to _nS(unref(nodeStyle))), _uA(
                        if (isTrue(_ctx.loading)) {
                            _cV(_component_rice_loading, _uM("key" to 0, "size" to "17", "color" to unref(iconColor)), null, 8, _uA(
                                "color"
                            ))
                        } else {
                            if (isTrue(unref(showInsidePrompt))) {
                                _cE(Fragment, _uM("key" to 1), _uA(
                                    if (isTrue(unref(hasIcon))) {
                                        _cV(_component_rice_icon, _uM("key" to 0, "name" to if (unref(isChecked)) {
                                            _ctx.activeIcon
                                        } else {
                                            _ctx.inactiveIcon
                                        }, "color" to unref(iconColor), "size" to _ctx.iconSize), null, 8, _uA(
                                            "name",
                                            "color",
                                            "size"
                                        ))
                                    } else {
                                        if (isTrue(unref(hasText))) {
                                            _cE("text", _uM("key" to 1, "class" to "rice-switch__node__text", "style" to _nS(unref(nodeTextStyle))), _tD(if (unref(isChecked)) {
                                                _ctx.activeText
                                            } else {
                                                _ctx.inactiveText
                                            }), 5)
                                        } else {
                                            _cC("v-if", true)
                                        }
                                    }
                                ), 64)
                            } else {
                                _cC("v-if", true)
                            }
                        }
                    ), 6)
                ), 6)
            }
        }
        var name = "rice-switch"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("rice-switch" to _pS(_uM("position" to "relative", "flexDirection" to "row", "alignItems" to "center", "borderTopLeftRadius" to 200, "borderTopRightRadius" to 200, "borderBottomRightRadius" to 200, "borderBottomLeftRadius" to 200, "height" to 28, "width" to 50, "boxSizing" to "border-box", "transitionProperty" to "color,backgroundColor", "transitionDuration" to "300ms")), "rice-switch__inner" to _pS(_uM("width" to "100%", "transitionProperty" to "padding", "transitionDuration" to "300ms", "paddingTop" to 0, "paddingRight" to 6, "paddingBottom" to 0, "paddingLeft" to 28, "boxSizing" to "border-box")), "rice-switch__inner__text" to _pS(_uM("fontSize" to 12, "textOverflow" to "ellipsis", "whiteSpace" to "nowrap", "color" to "rgba(255,255,255,0.9)", "textAlign" to "center")), "rice-switch__inner--active" to _pS(_uM("paddingTop" to 0, "paddingRight" to 28, "paddingBottom" to 0, "paddingLeft" to 6)), "rice-switch__node" to _pS(_uM("position" to "absolute", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "backgroundColor" to "#ffffff", "height" to 22, "width" to 22, "borderTopLeftRadius" to 200, "borderTopRightRadius" to 200, "borderBottomRightRadius" to 200, "borderBottomLeftRadius" to 200, "transitionProperty" to "transform", "transitionDuration" to "300ms", "boxShadow" to "0 2px 3px rgba(0, 0, 0, 0.2)")), "rice-switch__node__text" to _pS(_uM("fontSize" to 12, "transitionProperty" to "color", "transitionDuration" to "300ms", "whiteSpace" to "nowrap", "textAlign" to "center", "width" to "100%")), "rice-switch--disabled" to _pS(_uM("opacity" to 0.6)), "@TRANSITION" to _uM("rice-switch" to _uM("property" to "color,backgroundColor", "duration" to "300ms"), "rice-switch__inner" to _uM("property" to "padding", "duration" to "300ms"), "rice-switch__node" to _uM("property" to "transform", "duration" to "300ms"), "rice-switch__node__text" to _uM("property" to "color", "duration" to "300ms")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "update:modelValue" to null)
        var props = _nP(_uM("activeValue" to _uM("type" to _uA(
            "String",
            "Number",
            "Boolean"
        ), "required" to false, "default" to true), "inactiveValue" to _uM("type" to _uA(
            "String",
            "Number",
            "Boolean"
        ), "required" to false, "default" to false), "loading" to _uM("type" to "Boolean", "required" to false, "default" to false), "disabled" to _uM("type" to "Boolean", "required" to false, "default" to false), "readonly" to _uM("type" to "Boolean", "required" to false, "default" to false), "width" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "iconSize" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false, "default" to "12px"), "textSize" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "activeColor" to _uM("type" to "String", "required" to false), "inactiveColor" to _uM("type" to "String", "required" to false), "activeText" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "inactiveText" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "activeIcon" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "inactiveIcon" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "promptPosition" to _uM("type" to "String", "required" to false, "default" to "outball"), "beforeChange" to _uM("required" to false), "vibrate" to _uM("type" to "Boolean", "required" to false, "default" to true), "customStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (_uO())
        }
        ), "modelValue" to _uM("default" to false)))
        var propsNeedCastKeys = _uA(
            "activeValue",
            "inactiveValue",
            "loading",
            "disabled",
            "readonly",
            "iconSize",
            "promptPosition",
            "vibrate",
            "customStyle",
            "modelValue"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
