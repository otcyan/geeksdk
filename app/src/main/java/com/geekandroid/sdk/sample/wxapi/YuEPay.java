
/*******************************************************************************
 *
 * Copyright (c) 2016 Mickael Gizthon . All rights reserved. Email:2013mzhou@gmail.com
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.geekandroid.sdk.sample.wxapi;


import com.commonslibrary.commons.net.BaseRemoteModel;
import com.geekandroid.sdk.pay.impl.CHYuEPay;

import java.util.Map;

/**
 * date        :  2016-04-02  17:46
 * author      :  Mickaecle gizthon
 * description :
 */

public class YuEPay extends CHYuEPay {
    private BaseRemoteModel model = new BaseRemoteModel();

    //开启支付流程，请求订单 -> 获得请求参数 -> 调用客户端支付 -> 回调查询支付
    @Override
    public void pay(Map<String, Object> params, final RequestCallBack<String> callBack) {
        if (activity == null) {
            throw new NullPointerException("没有初始化支付");
        }
        showProgress();
        String url = params.get("url").toString();
        params.remove("url");//移除掉url


        model.doPost(url, params, new com.commonslibrary.commons.net.RequestCallBack<String>() {
            @Override
            public void onSuccess(String result) {
                hideProgress();
                if (callBack == null) {
                    return;
                }
                callBack.onSuccess(result);
            }

            @Override
            public void onFailure(String errorMessage, Exception exception) {
                hideProgress(errorMessage);
                if (callBack == null) {
                    return;
                }
                callBack.onFailure(errorMessage, exception);
            }
        });

    }

    @Override
    public void requestOrder(Map<String, Object> params, RequestCallBack<String> callBack) {

    }

    @Override
    public void getPayParam(Map<String, Object> params, RequestCallBack<String> callBack) {

    }

    @Override
    public void getPayResult(Map<String, Object> params, RequestCallBack<String> callBack) {

    }


}

