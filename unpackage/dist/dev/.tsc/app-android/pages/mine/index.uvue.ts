import _easycom_rice_icon from '@/uni_modules/rice-ui/components/rice-icon/rice-icon.uvue'
import _easycom_rice_badge from '@/uni_modules/rice-ui/components/rice-badge/rice-badge.uvue'
import _easycom_rice_cell from '@/uni_modules/rice-ui/components/rice-cell/rice-cell.uvue'
import _easycom_rice_cell_group from '@/uni_modules/rice-ui/components/rice-cell-group/rice-cell-group.uvue'
import MyNavbar from '@/componnets/MyNavbar.uvue'
	import MyAvatar from '@/componnets/MyAvatar.uvue'
	import { state, setAppTheme, setIsFollowSystem } from '@/store/index.uts'

	
const __sfc__ = defineComponent({
  __name: 'index',
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	const onAbout = () => {
		uni.showModal({
			title: '声明哦',
			content: `本应用 / 网站 / 内容仅供学习、交流及个人参考使用，不构成任何形式的投资建议、法律意见、专业指导或商业承诺。
	内容准确性：我们力求内容准确、完整、及时，但不保证所有信息绝对无误，不对因内容疏漏、错误或过时导致的任何损失承担责任。
	使用风险：用户基于本应用 / 内容进行的任何操作、决策或行为，均由用户自行承担风险，我们不承担任何直接、间接、附带或衍生的损失赔偿责任。
	第三方链接：本应用 / 内容可能包含第三方链接，第三方网站的内容、隐私政策及服务由其自行负责，我们不对其合法性、安全性及准确性负责。
	版权与合规：本应用 / 内容所使用的素材、代码、数据等，均尽可能遵循版权规范；若涉及侵权，请联系我们及时处理，我们不承担因用户违规使用素材导致的法律责任。
	变更与终止：我们有权随时更新、修改或终止本应用 / 内容，无需提前通知，且不承担因此产生的任何责任。
	适用范围：本声明适用于所有使用本应用 / 内容的用户，使用即视为已阅读、理解并同意本声明全部条款。
	如需适配特定场景（如小说阅读类、工具类、社区类、付费服务类），告诉我用途，我可以帮你定制更精准的版本。`,
			showCancel: false,
			confirmText: '知道了'
		})
	}

	const onSetTheme = (val : "light" | "dark") => {
		setAppTheme(val)
		setIsFollowSystem(false)
		if (state.uniPlatform === 'app') {
			uni.setAppTheme({
				theme: val as "light" | "dark" | "auto",
				success: function () {
					console.log(`设置appTheme为 ${val} 成功`, " at pages/mine/index.uvue:65")
				},
				fail: function (e : IAppThemeFail) {
					console.log(`设置appTheme为 ${val} 失败,原因:`, e.errMsg, " at pages/mine/index.uvue:68")
				}
			})
		}
	}

	const onShow = () => {
		console.log(688767868, " at pages/mine/index.uvue:75")
	}

	const onToSetting = () => uni.navigateTo({ url: '/pages/setting/index' })

	const onToFeedback = () => uni.navigateTo({ url: '/pages/feedback/index' })

return (): any | null => {

const _component_rice_icon = resolveEasyComponent("rice-icon",_easycom_rice_icon)
const _component_rice_badge = resolveEasyComponent("rice-badge",_easycom_rice_badge)
const _component_rice_cell = resolveEasyComponent("rice-cell",_easycom_rice_cell)
const _component_rice_cell_group = resolveEasyComponent("rice-cell-group",_easycom_rice_cell_group)

  return _cE("view", _uM({
    class: _nC([`rice-theme-${unref(state).appTheme}`, "page"])
  }), [
    _cV(unref(MyNavbar), _uM({ "left-arrow": false }), _uM({
      right: withSlotCtx((): any[] => [
        _cE("view", _uM({ class: "nav-right" }), [
          unref(state).appTheme=='dark'
            ? _cV(_component_rice_icon, _uM({
                key: 0,
                name: "sun",
                size: "24",
                class: "nac-icon",
                onClick: () => {onSetTheme('light')}
              }), null, 8 /* PROPS */, ["onClick"])
            : _cV(_component_rice_icon, _uM({
                key: 1,
                name: "sleep",
                size: "24",
                class: "nac-icon",
                onClick: () => {onSetTheme('dark')}
              }), null, 8 /* PROPS */, ["onClick"]),
          _cV(_component_rice_badge, _uM({ value: 5 }), _uM({
            default: withSlotCtx((): any[] => [
              _cV(_component_rice_icon, _uM({
                name: "remind",
                size: "24",
                class: "nac-icon"
              }))
            ]),
            _: 1 /* STABLE */
          }))
        ])
      ]),
      _: 1 /* STABLE */
    })),
    _cE("view", _uM({ class: "header" }), [
      _cE("view", _uM({ class: "header-avatar" }), [
        _cV(unref(MyAvatar), _uM({
          src: "/static/image/avatar.jpg",
          mode: "aspectFit",
          style: _nS(_uM({"width":"100%","height":"100%"}))
        }), null, 8 /* PROPS */, ["style"])
      ]),
      _cE("view", _uM({ class: "h-right" }), [
        _cE("text", _uM({ class: "h-text1" }), "昵称"),
        _cE("text", _uM({ class: "h-text2" }), "等级")
      ])
    ]),
    _cE("view", _uM({ class: "card" }), [
      _cV(_component_rice_cell_group, _uM({ border: "" }), _uM({
        default: withSlotCtx((): any[] => [
          _cV(_component_rice_cell, _uM({
            title: "活动",
            arrow: ""
          })),
          _cV(_component_rice_cell, _uM({
            title: "设置",
            arrow: "",
            onClick: onToSetting
          })),
          _cV(_component_rice_cell, _uM({
            title: "反馈",
            arrow: "",
            onClick: onToFeedback
          })),
          _cV(_component_rice_cell, _uM({
            title: "关于",
            value: "0.0.1",
            arrow: "",
            onClick: onAbout
          }))
        ]),
        _: 1 /* STABLE */
      }))
    ])
  ], 2 /* CLASS */)
}
}

})
export default __sfc__
const GenPagesMineIndexStyles = [_uM([["page", _pS(_uM([["backgroundColor", "var(--rice-navbar-background)"], ["height", "100%"], ["width", "100%"]]))], ["nav-right", _pS(_uM([["display", "flex"], ["flexDirection", "row"], ["marginRight", 15]]))], ["nac-icon", _uM([[".nav-right ", _uM([["marginLeft", 10]])]])], ["header", _pS(_uM([["marginTop", 12], ["marginRight", 16], ["marginBottom", 12], ["marginLeft", 16], ["display", "flex"], ["flexDirection", "row"]]))], ["header-avatar", _uM([[".header ", _uM([["width", 80], ["height", 80]])]])], ["h-right", _uM([[".header ", _uM([["marginLeft", 10], ["display", "flex"], ["justifyContent", "center"]])]])], ["h-text1", _uM([[".header ", _uM([["color", "var(--rice-text-color)"], ["fontSize", 16]])]])], ["h-text2", _uM([[".header ", _uM([["marginTop", 4], ["fontSize", 14], ["color", "var(--rice-text-color-2)"]])]])], ["card", _pS(_uM([["paddingTop", 12], ["paddingRight", 16], ["paddingBottom", 12], ["paddingLeft", 16], ["marginTop", 8]]))], ["rice-icon", _uM([[".card ", _uM([["lineHeight", "24px"]])]])]])]
