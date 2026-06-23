import _easycom_uni_badge_view from '@/uni_modules/uni-badge-view/components/uni-badge-view/uni-badge-view.uvue'
import MyNavbar from '@/componnets/MyNavbar/index.uvue';
	import MyAvatar from '@/componnets/MyAvatar/index.uvue';
	import MyCell from '@/componnets/MyCell/index.uvue';
	import MyCellGroup from '@/componnets/MyCellGroup/index.uvue';
	import MyIcon from '@/componnets/MyIcon/index.uvue';
	import { state, setAppTheme, setIsFollowSystem } from '@/store/index.uts';

	
const __sfc__ = defineComponent({
  __name: 'index',
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	const style = computed(() => {
		return {
			paddingTop: state.statusBarHeight + state.navbarHeight + 'px',
			paddingBottom: state.safeAreaInsetsHeight + 'px',
		};
	})

	const onSetTheme = (val : 'light' | 'dark') => {
		setAppTheme(val);
		setIsFollowSystem(false);
		if (state.uniPlatform === 'app') {
			uni.setAppTheme({
				theme: val as 'light' | 'dark' | 'auto',
				success: function () {
					console.log(`设置appTheme为 ${val} 成功`, " at pages/mine/index.uvue:56");
				},
				fail: function (e : IAppThemeFail) {
					console.log(`设置appTheme为 ${val} 失败,原因:`, e.errMsg, " at pages/mine/index.uvue:59");
				}
			});
		}
	};

	const onShow = () => {
		console.log(688767868, " at pages/mine/index.uvue:66");
	};

	const onToAbout = () => {
		uni.navigateTo({ url: '/pages/explanation/index' });
	};

	const onToSetting = () => {
		uni.navigateTo({ url: '/pages/setting/index' });
	}

	const onToFeedback = () => {
		uni.navigateTo({ url: '/pages/feedback/index' });
	}

return (): any | null => {

const _component_uni_badge_view = resolveEasyComponent("uni-badge-view",_easycom_uni_badge_view)

  return _cE("view", _uM({
    class: _nC([`theme-${unref(state).appTheme}`, 'page']),
    style: _nS(unref(style))
  }), [
    _cV(unref(MyNavbar), null, _uM({
      right: withSlotCtx((): any[] => [
        _cE("view", _uM({ class: "nav-right" }), [
          unref(state).appTheme == 'dark'
            ? _cV(unref(MyIcon), _uM({
                key: 0,
                name: "sun",
                size: 24,
                onClick: () => {onSetTheme('light')}
              }), null, 8 /* PROPS */, ["onClick"])
            : _cV(unref(MyIcon), _uM({
                key: 1,
                name: "moon",
                size: 24,
                onClick: () => {onSetTheme('dark')}
              }), null, 8 /* PROPS */, ["onClick"]),
          _cV(_component_uni_badge_view, _uM({ text: "5" }), _uM({
            default: withSlotCtx((): any[] => [
              _cV(unref(MyIcon), _uM({
                name: "notification",
                size: 24,
                style: _nS(_uM({"margin-left":"8px"}))
              }), null, 8 /* PROPS */, ["style"])
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
    _cV(unref(MyCellGroup), _uM({ inset: true }), _uM({
      default: withSlotCtx((): any[] => [
        _cV(unref(MyCell), _uM({
          title: "活动",
          arrow: true
        })),
        _cV(unref(MyCell), _uM({
          title: "设置",
          arrow: true,
          onClick: onToSetting
        })),
        _cV(unref(MyCell), _uM({
          title: "反馈",
          arrow: true,
          onClick: onToFeedback
        })),
        _cV(unref(MyCell), _uM({
          title: "关于",
          arrow: true,
          onClick: onToAbout
        }))
      ]),
      _: 1 /* STABLE */
    }))
  ], 6 /* CLASS, STYLE */)
}
}

})
export default __sfc__
const GenPagesMineIndexStyles = [_uM([["page", _pS(_uM([["backgroundColor", "var(--navbar-background)"], ["height", "100%"], ["width", "100%"]]))], ["nav-right", _pS(_uM([["display", "flex"], ["flexDirection", "row"], ["marginRight", 16], ["overflow", "visible"]]))], ["nav-icon", _uM([[".nav-right ", _uM([["fontSize", 24], ["marginLeft", 12]])], [".card ", _uM([["lineHeight", "24px"]])]])], ["header", _pS(_uM([["marginTop", 12], ["marginRight", 16], ["marginBottom", 12], ["marginLeft", 16], ["display", "flex"], ["flexDirection", "row"]]))], ["header-avatar", _uM([[".header ", _uM([["width", 80], ["height", 80]])]])], ["h-right", _uM([[".header ", _uM([["marginLeft", 12], ["display", "flex"], ["justifyContent", "center"], ["overflow", "visible"]])]])], ["h-text1", _uM([[".header ", _uM([["color", "var(--text-color-1)"], ["fontSize", 16]])]])], ["h-text2", _uM([[".header ", _uM([["marginTop", 4], ["fontSize", 14], ["color", "var(--text-color-2)"]])]])], ["card", _pS(_uM([["marginTop", 12], ["marginRight", 16], ["marginBottom", 12], ["marginLeft", 16], ["borderTopLeftRadius", 16], ["borderTopRightRadius", 16], ["borderBottomRightRadius", 16], ["borderBottomLeftRadius", 16], ["overflow", "hidden"]]))]])]
