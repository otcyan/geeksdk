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

package com.commonslibrary.commons.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;

public class BroadcastUtils {
    private BroadcastUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }
    public static void registerBroadcast(Context context, String action, BroadcastReceiver broadcastReceiver) {
        if (context == null || TextUtils.isEmpty(action) || broadcastReceiver == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(action);
        context.registerReceiver(broadcastReceiver, intentFilter);
    }

    public static void sendBrodcast(Context context, String action, String content) {
        if (TextUtils.isEmpty(action) || context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(action);
        intent.putExtra("extra", content);
        context.sendBroadcast(intent);
    }

    public static void sendBrodcast(Context context, String action, Bundle bundle) {
        if (TextUtils.isEmpty(action) || context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(action);
        intent.putExtra("extra", bundle);
        context.sendBroadcast(intent);
    }

    public static void unRegister(Context context, BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null || context == null) {
            return;
        }
        context.unregisterReceiver(broadcastReceiver);
    }
}
