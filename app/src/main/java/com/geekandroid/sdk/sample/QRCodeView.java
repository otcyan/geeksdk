
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

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.geekandroid.sdk.qrcode.ViewfinderView;

/**
 * date        :  2016-03-01  10:43
 * author      :  Mickaecle gizthon
 * description :
 */

public class QRCodeView extends ViewfinderView {
    public QRCodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public int getMaskColor() {
        return getResources().getColor(R.color.viewfinder_mask);
    }

    @Override
    public int getResultColor() {
        return getResources().getColor(R.color.result_view);
    }

    @Override
    public Drawable getLineDrawable() {
        return getResources().getDrawable(R.mipmap.qr_scan_line);
    }

    @Override
    public int getResultPointColor() {
        return getResources().getColor(R.color.possible_result_points);

    }

    @Override
    public int getViewFinderFrameColor() {
        return getResources().getColor(R.color.viewfinder_frame);
    }
}

