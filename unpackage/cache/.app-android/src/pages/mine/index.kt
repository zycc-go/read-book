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
import io.dcloud.uniapp.extapi.getAppBaseInfo as uni_getAppBaseInfo
import io.dcloud.uniapp.extapi.setAppTheme as uni_setAppTheme
open class GenPagesMineIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesMineIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesMineIndex
            val _cache = __ins.renderCache
            val message = "本应用 / 网站 / 内容仅供学习、交流及个人参考使用，不构成任何形式的投资建议、法律意见、专业指导或商业承诺。\n\t内容准确性：我们力求内容准确、完整、及时，但不保证所有信息绝对无误，不对因内容疏漏、错误或过时导致的任何损失承担责任。\n\t使用风险：用户基于本应用 / 内容进行的任何操作、决策或行为，均由用户自行承担风险，我们不承担任何直接、间接、附带或衍生的损失赔偿责任。\n\t第三方链接：本应用 / 内容可能包含第三方链接，第三方网站的内容、隐私政策及服务由其自行负责，我们不对其合法性、安全性及准确性负责。\n\t版权与合规：本应用 / 内容所使用的素材、代码、数据等，均尽可能遵循版权规范；若涉及侵权，请联系我们及时处理，我们不承担因用户违规使用素材导致的法律责任。\n\t变更与终止：我们有权随时更新、修改或终止本应用 / 内容，无需提前通知，且不承担因此产生的任何责任。\n\t适用范围：本声明适用于所有使用本应用 / 内容的用户，使用即视为已阅读、理解并同意本声明全部条款。\n\t如需适配特定场景（如小说阅读类、工具类、社区类、付费服务类），告诉我用途，我可以帮你定制更精准的版本。"
            val showMoreMessage = ref(false)
            val theme = ref<String?>("light")
            val getTheme = fun(){
                val res = uni_getAppBaseInfo(null)
                theme.value = res.appTheme
            }
            val onAbout = fun(){
                showMoreMessage.value = true
            }
            val onSetTheme = fun(kVal: String){
                theme.value = kVal
                setTheme(kVal as String)
                uni_setAppTheme(SetAppThemeOptions(theme = kVal as String, success = fun(_) {
                    console.log("设置appTheme为 auto 成功", " at pages/mine/index.uvue:67")
                }
                , fail = fun(e: IAppThemeFail) {
                    console.log("设置appTheme为 auto 失败,原因:", e.errMsg, " at pages/mine/index.uvue:70")
                }
                ))
            }
            onMounted(fun(){
                getTheme()
            }
            )
            return fun(): Any? {
                val _component_rice_icon = resolveEasyComponent("rice-icon", GenUniModulesRiceUiComponentsRiceIconRiceIconClass)
                val _component_rice_navbar = resolveEasyComponent("rice-navbar", GenUniModulesRiceUiComponentsRiceNavbarRiceNavbarClass)
                val _component_rice_avatar = resolveEasyComponent("rice-avatar", GenUniModulesRiceUiComponentsRiceAvatarRiceAvatarClass)
                val _component_rice_cell = resolveEasyComponent("rice-cell", GenUniModulesRiceUiComponentsRiceCellRiceCellClass)
                val _component_rice_cell_group = resolveEasyComponent("rice-cell-group", GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroupClass)
                val _component_rice_dialog = resolveEasyComponent("rice-dialog", GenUniModulesRiceUiComponentsRiceDialogRiceDialogClass)
                return _cE(Fragment, null, _uA(
                    _cE("view", null, _uA(
                        _cV(_component_rice_navbar, _uM("left-arrow" to false, "bg-color" to "#f8f8f8"), _uM("right" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", _uM("class" to "nav-right"), _uA(
                                    if (unref(theme) === "light") {
                                        _cV(_component_rice_icon, _uM("key" to 0, "name" to "sun", "class" to "nac-icon", "onClick" to fun(){
                                            onSetTheme("dark")
                                        }), null, 8, _uA(
                                            "onClick"
                                        ))
                                    } else {
                                        _cV(_component_rice_icon, _uM("key" to 1, "name" to "sleep", "class" to "nac-icon", "onClick" to fun(){
                                            onSetTheme("light")
                                        }
                                        ), null, 8, _uA(
                                            "onClick"
                                        ))
                                    }
                                    ,
                                    _cV(_component_rice_icon, _uM("name" to "remind", "class" to "nac-icon"))
                                ))
                            )
                        }
                        ), "_" to 1)),
                        _cE("view", _uM("class" to "header"), _uA(
                            _cV(_component_rice_avatar, _uM("src" to "/static/images/avatar-square.png", "size" to "large")),
                            _cE("view", _uM("class" to "h-right"), _uA(
                                _cE("text", _uM("class" to "h-text1"), "昵称"),
                                _cE("text", _uM("class" to "h-text2"), "等级")
                            ))
                        )),
                        _cE("view", _uM("class" to "card"), _uA(
                            _cV(_component_rice_cell_group, _uM("border" to ""), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_rice_cell, _uM("title" to "时长", "arrow" to "")),
                                    _cV(_component_rice_cell, _uM("title" to "设置", "arrow" to "")),
                                    _cV(_component_rice_cell, _uM("title" to "关于", "arrow" to "", "onClick" to onAbout)),
                                    _cV(_component_rice_cell, _uM("title" to "版本", "arrow" to ""))
                                )
                            }
                            ), "_" to 1))
                        ))
                    )),
                    _cV(_component_rice_dialog, _uM("show" to unref(showMoreMessage), "onUpdate:show" to fun(`$event`: Boolean){
                        trySetRefValue(showMoreMessage, `$event`)
                    }
                    , "title" to "关于", "show-cancel-button" to false, "message" to message, "confirm-button-text" to "知道了"), null, 8, _uA(
                        "show"
                    ))
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ), _uA(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("nav-right" to _pS(_uM("display" to "flex", "flexDirection" to "row", "marginRight" to 15, "gap" to "15px")), "nac-icon" to _uM(".nav-right " to _uM("fontSize" to 26, "marginLeft" to 5)), "header" to _pS(_uM("marginTop" to 12, "marginRight" to 15, "marginBottom" to 12, "marginLeft" to 15, "display" to "flex", "flexDirection" to "row")), "h-right" to _uM(".header " to _uM("marginLeft" to 10, "fontSize" to 10, "display" to "flex", "justifyContent" to "center")), "h-text2" to _uM(".header " to _uM("marginTop" to 4, "fontSize" to 14)), "card" to _pS(_uM("paddingTop" to 12, "paddingRight" to 15, "paddingBottom" to 12, "paddingLeft" to 15, "marginTop" to 8)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
