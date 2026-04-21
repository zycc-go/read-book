import _easycom_rice_avatar from '@/uni_modules/rice-ui/components/rice-avatar/rice-avatar.uvue'
import _easycom_rice_icon from '@/uni_modules/rice-ui/components/rice-icon/rice-icon.uvue'
import _easycom_rice_back_top from '@/uni_modules/rice-ui/components/rice-back-top/rice-back-top.uvue'
import { state, setAppTheme } from '@/store/index.uts'
	import { discussListFun, type DiscussItem } from '@/data/discuss'

	type BadgeItem = { __$originalPosition?: UTSSourceMapPosition<"BadgeItem", "pages/discuss/index.uvue", 65, 7>;
		name : string;
		isDot ?: boolean;
		dotNum ?: number;
	}
	
const __sfc__ = defineComponent({
  __name: 'index',
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	const title = ref('discuss')

	const scrollTop = ref<number>(0)

	const refresherTriggered = ref<boolean>(false)

	const discussListC = ref<DiscussItem[]>(discussListFun())

	const loadinghandle = ref<boolean>(false)

	const activeIndex2 = ref(0)

	const listBadge = ref<BadgeItem[]>([
		{ name: '推荐', isDot: true },
		{ name: '关注', dotNum: 10 },
		{ name: '我的收藏', dotNum: 999 },
		{ name: 'AI' }])
	const activeTab = ref<number>(0)
	const onChangeTab = (item : BadgeItem, index : string) => {
		activeTab.value = index
	}

	const onHandle = (item : DiscussItem, val : string) => {
		if (!loadinghandle.value) {
			uni.showToast({ title: val, icon: 'none' })
			loadinghandle.value = true
			setTimeout(() => {
				loadinghandle.value = false
				const index = discussListC.value.findIndex(discuss => discuss.id === item.id)
				const keyIs = `is${val.charAt(0).toUpperCase() + val.slice(1)}`
				const keyNum = `${val}Num`
				if (['good', 'like'].includes(val)) {
					if (discussListC.value[index][keyIs] as boolean) {
						discussListC.value[index][keyNum] = discussListC.value[index][keyNum] as number - 1
					} else {
						discussListC.value[index][keyNum] = discussListC.value[index][keyNum] as number + 1
					}
					discussListC.value[index][keyIs] = !(discussListC.value[index][keyIs] as boolean)
				} else {
					discussListC.value[index][keyNum] = discussListC.value[index][keyNum] as number + 1
				}
				uni.hideToast()
			}, 2000)
		}
	}

	const onRefresherrefresh = () => {
		refresherTriggered.value = true
		setTimeout(() => {
			discussListC.value = discussListFun()
			refresherTriggered.value = false
		}, 2000)
	}

	onPageScroll((options : OnPageScrollOptions) => {
		scrollTop.value = options.scrollTop
	})

return (): any | null => {

const _component_rice_avatar = resolveEasyComponent("rice-avatar",_easycom_rice_avatar)
const _component_rice_icon = resolveEasyComponent("rice-icon",_easycom_rice_icon)
const _component_rice_back_top = resolveEasyComponent("rice-back-top",_easycom_rice_back_top)

  return _cE("view", _uM({
    class: _nC([`rice-theme-${unref(state).appTheme}`, "page"]),
    style: _nS(_uM({ paddingTop:`${unref(state).statusBarHeight}px`}))
  }), [
    _cE("view", _uM({ class: "tabs" }), [
      _cE(Fragment, null, RenderHelpers.renderList(unref(listBadge), (item, index, __index, _cached): any => {
        return _cE("view", _uM({
          class: "tab",
          key: item.name,
          onClick: () => {onChangeTab(item, index)}
        }), [
          _cE("text", _uM({ class: "item-text" }), _tD(item.name), 1 /* TEXT */),
          unref(activeTab) === index
            ? _cE("view", _uM({
                key: 0,
                class: "tab-indicator"
              }))
            : _cC("v-if", true)
        ], 8 /* PROPS */, ["onClick"])
      }), 128 /* KEYED_FRAGMENT */)
    ]),
    _cE("scroll-view", _uM({
      id: "backId",
      direction: "vertical",
      style: _nS(_uM({"flex":"1"})),
      "refresher-enabled": true,
      "enable-passive": true,
      "refresher-triggered": unref(refresherTriggered),
      onRefresherrefresh: onRefresherrefresh
    }), [
      _cE("view", _uM({ class: "card" }), [
        _cE(Fragment, null, RenderHelpers.renderList(unref(discussListC), (item, index, __index, _cached): any => {
          return _cE("view", _uM({
            key: item.id,
            class: _nC(['item', index > 0 ? 'item-index' : ''])
          }), [
            _cE("view", _uM({ class: "item-top" }), [
              _cV(_component_rice_avatar, _uM({
                icon: "star",
                size: "mini"
              })),
              _cE("view", _uM({ class: "item-text" }), [
                _cE("text", _uM({ class: "item-tit" }), _tD(item.name), 1 /* TEXT */)
              ])
            ]),
            _cE("text", _uM({ class: "item-content" }), _tD(item.content), 1 /* TEXT */),
            _cE("view", _uM({ class: "item-bottom" }), [
              _cE("view", _uM({
                class: "item-hand",
                onClick: () => {onHandle(item, 'good')}
              }), [
                isTrue(item.isGood)
                  ? _cV(_component_rice_icon, _uM({
                      key: 0,
                      name: "good-fill",
                      color: "#ff0000"
                    }))
                  : _cV(_component_rice_icon, _uM({
                      key: 1,
                      name: "good"
                    })),
                _cE("text", _uM({ class: "item-hand-num" }), " " + _tD(item.goodNum), 1 /* TEXT */)
              ], 8 /* PROPS */, ["onClick"]),
              _cE("view", _uM({
                class: "item-hand",
                onClick: () => {onHandle(item, 'like')}
              }), [
                isTrue(item.isLike)
                  ? _cV(_component_rice_icon, _uM({
                      key: 0,
                      name: "like-fill",
                      color: "#ff0000"
                    }))
                  : _cV(_component_rice_icon, _uM({
                      key: 1,
                      name: "like"
                    })),
                _cE("text", _uM({ class: "item-hand-num" }), " " + _tD(item.likeNum), 1 /* TEXT */)
              ], 8 /* PROPS */, ["onClick"]),
              _cE("view", _uM({ class: "item-hand" }), [
                _cV(_component_rice_icon, _uM({ name: "eyes" })),
                _cE("text", _uM({ class: "item-hand-num" }), " " + _tD(item.viewNum), 1 /* TEXT */)
              ]),
              _cE("view", _uM({
                class: "item-hand",
                onClick: () => {onHandle(item, 'share')}
              }), [
                _cV(_component_rice_icon, _uM({ name: "share" })),
                _cE("text", _uM({ class: "item-hand-num" }), " " + _tD(item.shareNum), 1 /* TEXT */)
              ], 8 /* PROPS */, ["onClick"])
            ])
          ], 2 /* CLASS */)
        }), 128 /* KEYED_FRAGMENT */)
      ]),
      _cV(_component_rice_back_top, _uM({ parentId: "backId" }))
    ], 44 /* STYLE, PROPS, NEED_HYDRATION */, ["refresher-triggered"])
  ], 6 /* CLASS, STYLE */)
}
}

})
export default __sfc__
const GenPagesDiscussIndexStyles = [_uM([["page", _pS(_uM([["backgroundColor", "var(--rice-navbar-background)"], ["height", "100%"], ["width", "100%"]]))], ["tabs", _pS(_uM([["height", 44], ["display", "flex"], ["flexDirection", "row"], ["alignItems", "center"], ["paddingTop", 0], ["paddingRight", 4], ["paddingBottom", 0], ["paddingLeft", 4]]))], ["tab", _uM([[".tabs ", _uM([["paddingTop", 0], ["paddingRight", 12], ["paddingBottom", 0], ["paddingLeft", 12], ["position", "relative"], ["display", "flex"], ["flexDirection", "row"], ["alignItems", "center"], ["height", "100%"]])]])], ["tab-indicator", _uM([[".tabs ", _uM([["width", 20], ["height", 3], ["position", "absolute"], ["bottom", 4], ["left", "50%"], ["transform", "translateX(-50%)"], ["zIndex", 1], ["borderTopLeftRadius", 100], ["borderTopRightRadius", 100], ["borderBottomRightRadius", 100], ["borderBottomLeftRadius", 100], ["backgroundColor", "var(--rice-primary-color)"]])]])], ["item-text", _uM([[".tabs ", _uM([["color", "var(--text-color1)"]])], [".card .item .item-top ", _uM([["marginLeft", 5]])]])], ["card", _pS(_uM([["paddingTop", 0], ["paddingRight", 16], ["paddingBottom", 12], ["paddingLeft", 16]]))], ["item-index", _uM([[".card ", _uM([["marginTop", 8]])]])], ["item", _uM([[".card ", _uM([["paddingTop", 12], ["paddingRight", 16], ["paddingBottom", 12], ["paddingLeft", 16], ["backgroundColor", "var(--background-color3)"], ["borderTopLeftRadius", 6], ["borderTopRightRadius", 6], ["borderBottomRightRadius", 6], ["borderBottomLeftRadius", 6]])]])], ["item-top", _uM([[".card .item ", _uM([["display", "flex"], ["flexDirection", "row"], ["alignItems", "center"]])]])], ["item-tit", _uM([[".card .item .item-top .item-text ", _uM([["color", "var(--text-color1)"]])]])], ["item-content", _uM([[".card .item ", _uM([["paddingTop", 12], ["paddingRight", 0], ["paddingBottom", 12], ["paddingLeft", 0], ["color", "var(--text-color2)"]])]])], ["item-bottom", _uM([[".card .item ", _uM([["display", "flex"], ["flexDirection", "row"], ["alignItems", "center"], ["justifyContent", "space-around"]])]])], ["item-hand", _uM([[".card .item ", _uM([["display", "flex"], ["flexDirection", "row"], ["alignItems", "center"], ["justifyContent", "center"], ["flexGrow", 1], ["flexShrink", 1], ["flexBasis", "0%"]])]])], ["item-hand-num", _uM([[".card .item .item-hand ", _uM([["color", "var(--text-color1)"], ["fontSize", 12]])]])]])]
