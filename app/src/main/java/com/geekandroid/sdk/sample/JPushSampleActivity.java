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

package com.geekandroid.sdk.sample;

import android.os.Bundle;
import android.view.View;

import com.commonslibrary.commons.utils.ToastUtils;
import com.geekandroid.sdk.jpushlibrary.push.IPushCallBack;
import com.geekandroid.sdk.jpushlibrary.push.impl.JPushImpl;

import java.util.Set;

/**
 * date        :  2016-02-04  18:37
 * author      :  Mickaecle gizthon
 * description :
 */
public class JPushSampleActivity extends BaseActivity {
    //        http://docs.jpush.io/guideline/android_guide/
    //        http://docs.jpush.io/client/android_api/#api_3
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jpush);

        findViewById(R.id.resumePush).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JPushImpl.getInstance().resumePush();
                logI("resumePush");
                ToastUtils.show(JPushSampleActivity.this,"resumePush");
            }
        });
        findViewById(R.id.stopPush).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JPushImpl.getInstance().stopPush();
                logI("stopPush");
                ToastUtils.show(JPushSampleActivity.this,"stopPush");
            }
        });
        findViewById(R.id.setAlias).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                JPushImpl.getInstance().setAlias("5", new IPushCallBack() {
                    @Override
                    public void gotResult(int i, String s, Set<String> set) {
                        logI(" got Result : i = " + i + " ,s = " + s + " ,set = " + set);
                        ToastUtils.show(JPushSampleActivity.this," got Result : i = " + i + " ,s = " + s + " ,set = " + set);
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
