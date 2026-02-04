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
open class GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroup : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var title: Any? by `$props`
    open var border: Boolean by `$props`
    open var radius: Any? by `$props`
    open var titleStyle: UTSJSONObject by `$props`
    open var customStyle: UTSJSONObject by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroup) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroup
            val _cache = __ins.renderCache
            val ns = useNamespace("cell-group")
            val props = __props
            val cellGroupStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (props.radius != null) {
                    css.set("border-radius", addUnit(props.radius!!))
                }
                return css
            }
            )
            val cellGroupClass = computed(fun(): UTSArray<String> {
                return _uA(
                    ns.b(""),
                    ns.theme(),
                    ns.`is`("border", props.border)
                )
            }
            )
            val cellGroupTitleClass = computed(fun(): UTSArray<String> {
                return _uA(
                    ns.theme()
                )
            }
            )
            return fun(): Any? {
                return _cE(Fragment, null, _uA(
                    if (isTrue(unref(hasStrValue)(_ctx.title))) {
                        _cE("text", _uM("key" to 0, "class" to _nC(_uA(
                            "rice-cell-group__title",
                            unref(cellGroupTitleClass)
                        )), "style" to _nS(_ctx.titleStyle)), _tD(_ctx.title), 7)
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cE("view", _uM("class" to _nC(unref(cellGroupClass)), "style" to _nS(_uA(
                        unref(cellGroupStyle),
                        _ctx.customStyle
                    ))), _uA(
                        renderSlot(_ctx.`$slots`, "default")
                    ), 6)
                ), 64)
            }
        }
        var name = "rice-cell-group"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("rice-cell-group" to _pS(_uM("backgroundColor" to "var(--rice-cell-background)")), "rice-cell-group__title" to _pS(_uM("paddingTop" to "var(--rice-padding-md)", "paddingRight" to "var(--rice-padding-md)", "paddingBottom" to "var(--rice-padding-md)", "paddingLeft" to "var(--rice-padding-md)", "color" to "var(--rice-text-color-2)", "fontSize" to "var(--rice-font-size-basic)")), "rice-cell-group--border" to _pS(_uM("borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "var(--rice-border-color)", "borderTopWidth" to "1rpx", "borderTopStyle" to "solid", "borderTopColor" to "var(--rice-border-color)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("title" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "border" to _uM("type" to "Boolean", "required" to false, "default" to false), "radius" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "titleStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "customStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        )))
        var propsNeedCastKeys = _uA(
            "border",
            "titleStyle",
            "customStyle"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
