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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class GenUniModulesRiceUiComponentsRiceCellRiceCell : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var title: Any? by `$props`
    open var value: Any? by `$props`
    open var label: Any? by `$props`
    open var size: String? by `$props`
    open var icon: String? by `$props`
    open var url: String? by `$props`
    open var border: Boolean by `$props`
    open var clickable: Boolean by `$props`
    open var arrow: Boolean? by `$props`
    open var arrowDirection: String by `$props`
    open var center: Boolean by `$props`
    open var titleStyle: UTSJSONObject by `$props`
    open var valueStyle: UTSJSONObject by `$props`
    open var labelStyle: UTSJSONObject by `$props`
    open var customStyle: UTSJSONObject by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesRiceUiComponentsRiceCellRiceCell) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesRiceUiComponentsRiceCellRiceCell
            val _cache = __ins.renderCache
            val ns = useNamespace("cell")
            val slots = useSlots()
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val showArrow = computed(fun(): Boolean {
                return props.arrow ?: hasStrValue(props.url)
            }
            )
            val hasLeftIcon = computed(fun(): Boolean {
                return slots["leftIcon"] != null || hasStrValue(props.icon)
            }
            )
            val hasValue = computed(fun(): Boolean {
                return slots["value"] != null || hasStrValue(props.value)
            }
            )
            val hasLabel = computed(fun(): Boolean {
                return slots["label"] != null || hasStrValue(props.label)
            }
            )
            val iconSize = computed(fun(): String {
                return if (props.size == "large") {
                    "17px"
                } else {
                    "16px"
                }
            }
            )
            val handleClick = fun(e: UniPointerEvent){
                if (hasStrValue(props.url)) {
                    uni_navigateTo(NavigateToOptions(url = props.url!!, fail = fun(err){
                        debugWarn("Cell", err.errMsg)
                    }
                    ))
                }
                emit("click")
            }
            val cellClass = computed(fun(): UTSArray<String> {
                return _uA(
                    ns.b(""),
                    ns.theme(),
                    ns.m(props.size),
                    ns.`is`("center", props.center),
                    ns.`is`("border", props.border)
                )
            }
            )
            val hoverClass = computed(fun(): String {
                return if (props.clickable) {
                    "rice-cell--hover"
                } else {
                    "none"
                }
            }
            )
            return fun(): Any? {
                val _component_rice_icon = resolveEasyComponent("rice-icon", GenUniModulesRiceUiComponentsRiceIconRiceIconClass)
                return _cE("view", _uM("class" to _nC(unref(cellClass)), "style" to _nS(_ctx.customStyle), "hover-stay-time" to 100, "hover-class" to unref(hoverClass), "onClick" to handleClick), _uA(
                    if (isTrue(unref(hasLeftIcon))) {
                        renderSlot(_ctx.`$slots`, "leftIcon", _uM("key" to 0), fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_rice_icon, _uM("name" to _ctx.icon, "custom-style" to object : UTSJSONObject() {
                                    var marginRight = "2px"
                                    var lineHeight: Number = 1.6
                                }, "size" to unref(iconSize)), null, 8, _uA(
                                    "name",
                                    "size"
                                ))
                            )
                        })
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("view", _uM("class" to _nC(unref(ns).e("title")), "style" to _nS(unref(splitCssProperty)(_ctx.titleStyle).rectCssProperty)), _uA(
                        renderSlot(_ctx.`$slots`, "title", UTSJSONObject(), fun(): UTSArray<Any> {
                            return _uA(
                                _cE("text", _uM("class" to "rice-cell__title__text", "style" to _nS(unref(splitCssProperty)(_ctx.titleStyle).textCssProperty)), _tD(_ctx.title), 5)
                            )
                        }
                        ),
                        if (isTrue(unref(hasLabel))) {
                            renderSlot(_ctx.`$slots`, "label", _uM("key" to 0), fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("text", _uM("class" to _nC(unref(ns).e("label")), "style" to _nS(_ctx.labelStyle)), _tD(_ctx.label), 7)
                                )
                            })
                        } else {
                            _cC("v-if", true)
                        }
                    ), 6),
                    if (isTrue(unref(hasValue))) {
                        _cE("view", _uM("key" to 1, "class" to _nC(unref(ns).e("value")), "style" to _nS(unref(splitCssProperty)(_ctx.valueStyle).rectCssProperty)), _uA(
                            renderSlot(_ctx.`$slots`, "value", UTSJSONObject(), fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("text", _uM("class" to "rice-cell__value__text", "style" to _nS(unref(splitCssProperty)(_ctx.valueStyle).textCssProperty)), _tD(_ctx.value), 5)
                                )
                            })
                        ), 6)
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    if (isTrue(_ctx.`$slots`["rightIcon"] != null || unref(showArrow))) {
                        renderSlot(_ctx.`$slots`, "rightIcon", _uM("key" to 2), fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_rice_icon, _uM("name" to ("arrow-" + _ctx.arrowDirection), "size" to unref(iconSize)), null, 8, _uA(
                                    "name",
                                    "size"
                                ))
                            )
                        })
                    } else {
                        _cC("v-if", true)
                    }
                ), 14, _uA(
                    "hover-class"
                ))
            }
        }
        var name = "rice-cell"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("rice-cell" to _pS(_uM("--rice-cell-title-size" to "15px", "--rice-cell-value-size" to "15px", "--rice-cell-label-size" to "13px", "flexDirection" to "row", "paddingTop" to 14, "paddingRight" to "var(--rice-padding-md)", "paddingBottom" to 14, "paddingLeft" to "var(--rice-padding-md)", "backgroundColor" to "var(--rice-cell-background)", "width" to "100%")), "rice-cell--medium" to _pS(_uM("--rice-cell-title-size" to "16px", "--rice-cell-value-size" to "16px", "--rice-cell-label-size" to "14px")), "rice-cell--large" to _pS(_uM("--rice-cell-title-size" to "17px", "--rice-cell-value-size" to "17px", "--rice-cell-label-size" to "15px", "paddingTop" to "var(--rice-font-size-lg)", "paddingRight" to "var(--rice-font-size-lg)", "paddingBottom" to "var(--rice-font-size-lg)", "paddingLeft" to "var(--rice-font-size-lg)")), "rice-cell__title" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "paddingRight" to 2)), "rice-cell__title__text" to _pS(_uM("lineHeight" to 1.6, "color" to "var(--rice-text-color)", "fontSize" to "var(--rice-cell-title-size)")), "rice-cell__value" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "paddingRight" to 2)), "rice-cell__value__text" to _pS(_uM("lineHeight" to 1.6, "color" to "var(--rice-text-color-2)", "fontSize" to "var(--rice-cell-value-size)", "textAlign" to "right")), "rice-cell__label" to _pS(_uM("color" to "var(--rice-text-color-2)", "fontSize" to "var(--rice-cell-label-size)", "marginTop" to 5)), "rice-cell--center" to _pS(_uM("alignItems" to "center")), "rice-cell--border" to _pS(_uM("borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "var(--rice-border-color)")), "rice-cell--hover" to _pS(_uM("backgroundColor" to "var(--rice-hover-color)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null)
        var props = _nP(_uM("title" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "value" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "label" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "size" to _uM("type" to "String", "required" to false), "icon" to _uM("type" to "String", "required" to false), "url" to _uM("type" to "String", "required" to false), "border" to _uM("type" to "Boolean", "required" to false, "default" to true), "clickable" to _uM("type" to "Boolean", "required" to false, "default" to true), "arrow" to _uM("type" to "Boolean", "required" to false, "default" to null), "arrowDirection" to _uM("type" to "String", "required" to false, "default" to "right"), "center" to _uM("type" to "Boolean", "required" to false, "default" to false), "titleStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "valueStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "labelStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "customStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        )))
        var propsNeedCastKeys = _uA(
            "border",
            "clickable",
            "arrow",
            "arrowDirection",
            "center",
            "titleStyle",
            "valueStyle",
            "labelStyle",
            "customStyle"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
