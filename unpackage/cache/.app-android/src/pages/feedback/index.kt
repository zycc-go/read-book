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
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesFeedbackIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesFeedbackIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesFeedbackIndex
            val _cache = __ins.renderCache
            val style = computed(fun(): UTSJSONObject {
                return _uO("paddingTop" to (state.statusBarHeight + state.navbarHeight + "px"), "paddingBottom" to (state.safeAreaInsetsHeight + "px"))
            }
            )
            val content = ref<String>("")
            val onInput = fun(event: UniInputEvent){
                content.value = event.detail.value
            }
            val onSubmit = fun(){
                if (content.value.length <= 0) {
                    uni_showToast(ShowToastOptions(title = "请输入内容", icon = "error"))
                    return
                }
                uni_showLoading(null)
                setTimeout(fun(){
                    uni_hideLoading(null)
                }
                , 1000)
            }
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(_uA(
                    "theme-" + unref(state).appTheme,
                    "page"
                )), "style" to _nS(unref(style))), _uA(
                    _cV(unref(GenComponnetsMyNavbarIndexClass), _uM("leftArrow" to "", "title" to "反馈")),
                    _cE("view", _uM("class" to "card"), _uA(
                        _cE("textarea", _uM("class" to "textarea-instance", "placeholder" to "请输入内容", "maxlength" to 500, "auto-focus" to true, "auto-height" to true, "value" to unref(content), "onInput" to onInput), null, 40, _uA(
                            "value"
                        )),
                        _cE("button", _uM("class" to "btn", "type" to "primary", "onClick" to onSubmit), "提交")
                    ))
                ), 6)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("page" to _pS(_uM("backgroundColor" to "var(--navbar-background)", "height" to "100%", "width" to "100%")), "card" to _pS(_uM("paddingTop" to 12, "paddingRight" to 16, "paddingBottom" to 12, "paddingLeft" to 16)), "textarea-instance" to _uM(".card " to _uM("minHeight" to 140, "width" to "100%", "paddingTop" to 12, "paddingRight" to 16, "paddingBottom" to 12, "paddingLeft" to 16, "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "fontSize" to 14, "color" to "var(--text-color-1)", "lineHeight" to "24px", "backgroundColor" to "var(--background-color-2)")), "btn" to _uM(".card " to _uM("marginTop" to 12)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
