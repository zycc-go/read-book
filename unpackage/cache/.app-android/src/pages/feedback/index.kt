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
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.switchTab as uni_switchTab
open class GenPagesFeedbackIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesFeedbackIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesFeedbackIndex
            val _cache = __ins.renderCache
            val value = ref<String>("")
            val onClickLeft = fun(){
                uni_switchTab(SwitchTabOptions(url = "/pages/mine/index"))
            }
            val onSubmit = fun(){
                uni_showLoading(null)
                setTimeout(fun(){
                    uni_hideLoading(null)
                }
                , 1000)
            }
            return fun(): Any? {
                val _component_rice_navbar = resolveEasyComponent("rice-navbar", GenUniModulesRiceUiComponentsRiceNavbarRiceNavbarClass)
                val _component_rice_textarea = resolveEasyComponent("rice-textarea", GenUniModulesRiceUiComponentsRiceTextareaRiceTextareaClass)
                val _component_rice_button = resolveEasyComponent("rice-button", GenUniModulesRiceUiComponentsRiceButtonRiceButtonClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "rice-theme-" + unref(state).appTheme,
                    "page"
                ))), _uA(
                    _cV(_component_rice_navbar, _uM("height" to unref(state).navbarHeight, "title" to "反馈", "onClickLeft" to onClickLeft), null, 8, _uA(
                        "height"
                    )),
                    _cE("view", _uM("class" to "card"), _uA(
                        _cV(_component_rice_textarea, _uM("modelValue" to unref(value), "onUpdate:modelValue" to fun(`$event`: String){
                            trySetRefValue(value, `$event`)
                        }
                        , "placeholder" to "请输入内容", "show-word-limit" to "", "maxlength" to 500), null, 8, _uA(
                            "modelValue"
                        )),
                        _cE("view", _uM("class" to "btn"), _uA(
                            _cV(_component_rice_button, _uM("type" to "primary", "text" to "提交", "onClick" to onSubmit))
                        ))
                    ))
                ), 2)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("page" to _pS(_uM("backgroundColor" to "var(--rice-navbar-background)", "height" to "100%", "width" to "100%")), "card" to _pS(_uM("paddingTop" to 12, "paddingRight" to 15, "paddingBottom" to 12, "paddingLeft" to 15)), "btn" to _uM(".card " to _uM("marginTop" to 12)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
