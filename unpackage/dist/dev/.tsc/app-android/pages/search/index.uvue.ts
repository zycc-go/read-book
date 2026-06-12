import { state } from '@/store/index.uts'
	import { getRandomDigits } from '@/utils/index.uts'

	type SearchRecordItem = { __$originalPosition?: UTSSourceMapPosition<"SearchRecordItem", "pages/search/index.uvue", 49, 7>;
		id : string,
		text : string
	}

	
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

	const keywords = ref<string>('')

	const searchRecord = ref<SearchRecordItem[]>([])

	const searchType = ref<string>('record')

	const onBack = () => {
		uni.navigateBack()
	}

	const onInput = (event : UniInputEvent) => {
		if (event.detail.value.length == 0) {
			searchType.value = 'record'
		}
	}

	const onClickAction = () => {
		if (keywords.value.length > 0) {
			searchType.value = 'result'
			if (searchRecord.value.findIndex(item1 => item1.text === keywords.value) < 0) {
				uni.showLoading({ title: '加载中...' })
				searchRecord.value.push({ id: getRandomDigits(12), text: keywords.value } as SearchRecordItem)
				uni.setStorage({
					key: 'searchRecord',
					data: searchRecord.value,
					complete: () => uni.hideLoading()
				})
			}
		} else if (searchType.value === 'result') {
			searchType.value = 'record'
		} else {
			uni.showToast({ title: '请输入内容', icon: 'error' })
		}
	}

	const onSearchItem = (item : SearchRecordItem) => {
		keywords.value = item.text
		onClickAction()
	}

	const onDeleteItem = (item : SearchRecordItem) => {
		searchRecord.value = searchRecord.value.filter(item1 => item1.id !== item.id)
		uni.setStorage({
			key: 'searchRecord',
			data: searchRecord.value,
			fail: (err : UniError) => {
				console.log(err, " at pages/search/index.uvue:107")
			}
		})
	}

	const onClearItems = () => {
		if (searchRecord.value.length > 0) {
			searchRecord.value = []
			uni.setStorage({
				key: 'searchRecord',
				data: searchRecord.value,
				fail: (err : UniError) => {
					console.log(err, " at pages/search/index.uvue:119")
				}
			})
		}
	}

	const initData = () => {
		uni.showLoading({ title: '加载中...' })
		uni.getStorage({
			key: 'searchRecord',
			success: (res : GetStorageSuccess) => {
				const data = UTSAndroid.consoleDebugError(JSON.parse<Array<SearchRecordItem>>(JSON.stringify(res.data)), " at pages/search/index.uvue:130")
				searchRecord.value = data ?? []
			},
			complete: () => uni.hideLoading()
		})
	}

	onMounted(() => {
		initData()
	})

return (): any | null => {

  return _cE("view", _uM({
    class: _nC([`theme-${unref(state).appTheme}`, 'page'])
  }), [
    _cE("view", _uM({
      class: "page-navbar",
      style: _nS(_uM({ height:`${unref(state).navbarHeight}px`, top:`${unref(state).statusBarHeight}px`}))
    }), [
      _cE("view", _uM({
        class: "page-navbar-left",
        onClick: onBack
      }), [
        _cE("text", _uM({ class: "icon" }), _tD("\ue668"))
      ]),
      _cE("view", _uM({ class: "input-wrapper" }), [
        _cE("input", _uM({
          focus: "",
          maxlength: 20,
          modelValue: unref(keywords),
          onInput: [($event: UniInputEvent) => {trySetRefValue(keywords, $event.detail.value)}, onInput] as Array<any | null>
        }), null, 40 /* PROPS, NEED_HYDRATION */, ["modelValue"])
      ]),
      _cE("text", _uM({
        class: "page-navbar-right",
        onClick: onClickAction
      }), "搜索")
    ], 4 /* STYLE */),
    _cE("view", _uM({
      class: "card",
      style: _nS(_uM({ paddingTop:`${unref(state).navbarHeight + unref(state).statusBarHeight}px`}))
    }), [
      unref(searchType) === 'record'
        ? _cE("view", _uM({
            key: 0,
            class: "card-title-box"
          }), [
            _cE("text", _uM({ class: "card-title" }), "历史记录"),
            _cE("view", _uM({
              class: "card-clear",
              onClick: onClearItems
            }), [
              _cE("text", _uM({ class: "card-clear-text" }), "清空"),
              _cE("text", _uM({ class: "icon" }), _tD("\ue6a6"))
            ])
          ])
        : _cC("v-if", true),
      unref(searchType) === 'result'
        ? _cE("view", _uM({
            key: 1,
            class: "card-title-box"
          }), [
            _cE("text", _uM({ class: "card-title" }), "搜索结果")
          ])
        : _cC("v-if", true)
    ], 4 /* STYLE */),
    _cE("scroll-view", _uM({
      style: _nS(_uM({"flex":"1"})),
      direction: "vertical",
      "scroll-with-animation": "true"
    }), [
      unref(searchRecord).length > 0
        ? _cE("view", _uM({
            key: 0,
            class: "tag-list"
          }), [
            _cE(Fragment, null, RenderHelpers.renderList(unref(searchRecord), (item, __key, __index, _cached): any => {
              return _cE("view", _uM({
                class: "tag-box",
                onClick: () => {onSearchItem(item)}
              }), [
                _cE("text", _uM({ class: "tag" }), _tD(item.text), 1 /* TEXT */),
                _cE("view", _uM({
                  onClick: withModifiers(() => {onDeleteItem(item)}, ["stop"])
                }), [
                  _cE("text", _uM({ class: "icon" }), _tD("\ue6a7"))
                ], 8 /* PROPS */, ["onClick"])
              ], 8 /* PROPS */, ["onClick"])
            }), 256 /* UNKEYED_FRAGMENT */)
          ])
        : _cE("view", _uM({
            key: 1,
            class: "empty"
          }), [
            _cE("text", _uM({ class: "text" }), "空空如也")
          ])
    ], 4 /* STYLE */)
  ], 2 /* CLASS */)
}
}

})
export default __sfc__
const GenPagesSearchIndexStyles = [_uM([["page", _pS(_uM([["backgroundColor", "var(--navbar-background)"], ["width", "100%"], ["height", "100%"]]))], ["page-navbar", _pS(_uM([["display", "flex"], ["flexDirection", "row"], ["alignItems", "center"], ["position", "fixed"], ["width", "100%"], ["zIndex", 99], ["backgroundColor", "var(--navbar-background)"]]))], ["page-navbar-left", _uM([[".page-navbar ", _uM([["width", "80rpx"], ["display", "flex"], ["flexDirection", "row"], ["alignItems", "center"], ["justifyContent", "center"]])]])], ["icon", _uM([[".page-navbar ", _uM([["fontSize", 24]])]])], ["input-wrapper", _uM([[".page-navbar ", _uM([["flexGrow", 1], ["flexShrink", 1], ["flexBasis", "0%"], ["display", "flex"], ["paddingTop", "16rpx"], ["paddingRight", "32rpx"], ["paddingBottom", "16rpx"], ["paddingLeft", "32rpx"], ["marginTop", "4rpx"], ["marginRight", 0], ["marginBottom", "4rpx"], ["marginLeft", 0], ["flexDirection", "row"], ["backgroundColor", "var(--background-color-3)"], ["borderTopLeftRadius", 16], ["borderTopRightRadius", 16], ["borderBottomRightRadius", 16], ["borderBottomLeftRadius", 16]])]])], ["page-navbar-right", _uM([[".page-navbar ", _uM([["width", "120rpx"], ["textAlign", "center"], ["color", "var(--text-color-1)"], ["fontSize", 16]])]])], ["card", _pS(_uM([["paddingTop", 0], ["paddingRight", 15], ["paddingBottom", 0], ["paddingLeft", 15]]))], ["card-title-box", _uM([[".card ", _uM([["display", "flex"], ["flexDirection", "row"], ["justifyContent", "space-between"]])]])], ["card-title", _uM([[".card .card-title-box ", _uM([["marginTop", 12], ["marginRight", 0], ["marginBottom", 12], ["marginLeft", 0], ["color", "var(--text-color-2)"]])]])], ["card-clear", _uM([[".card .card-title-box ", _uM([["display", "flex"], ["flexDirection", "row"], ["alignItems", "center"]])]])], ["card-clear-text", _uM([[".card .card-title-box .card-clear ", _uM([["color", "var(--text-color-2)"], ["fontSize", 14], ["marginRight", "4rpx"]])]])], ["tag-list", _pS(_uM([["display", "flex"], ["flexDirection", "row"], ["flexWrap", "wrap"], ["paddingTop", 0], ["paddingRight", 16], ["paddingBottom", 0], ["paddingLeft", 16]]))], ["tag-box", _uM([[".tag-list ", _uM([["paddingTop", 4], ["paddingRight", 8], ["paddingBottom", 4], ["paddingLeft", 8], ["borderTopLeftRadius", 3], ["borderTopRightRadius", 3], ["borderBottomRightRadius", 3], ["borderBottomLeftRadius", 3], ["backgroundColor", "var(--background-color-5)"], ["display", "flex"], ["flexDirection", "row"], ["alignItems", "center"], ["marginTop", 0], ["marginRight", 12], ["marginBottom", 12], ["marginLeft", 0]])]])], ["tag", _uM([[".tag-list ", _uM([["color", "var(--text-color-2)"], ["fontSize", 14], ["marginRight", 4]])]])], ["empty", _pS(_uM([["minHeight", "200rpx"], ["display", "flex"], ["alignItems", "center"], ["justifyContent", "center"], ["marginTop", 12], ["marginRight", 16], ["marginBottom", 12], ["marginLeft", 16], ["backgroundColor", "var(--background-color-3)"], ["borderTopLeftRadius", 8], ["borderTopRightRadius", 8], ["borderBottomRightRadius", 8], ["borderBottomLeftRadius", 8]]))], ["text", _uM([[".empty ", _uM([["color", "var(--text-color-3)"]])]])]])]
