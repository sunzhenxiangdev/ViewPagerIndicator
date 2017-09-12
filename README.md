# 自定义的ViewPager的指示线

### How to use
           
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        iv_main_indicator = (IndicatorView) findViewById(R.id.iv_main_indicator);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);
        //设置指示线
        iv_main_indicator.setBorderWidth(5);
        iv_main_indicator.setTriangleWidth(10);
        iv_main_indicator.setViewPager(mViewPager);
        
### LICENSE

        MIT License
        Copyright (c) 2017 孙振祥
        Permission is hereby granted, free of charge, to any person obtaining a copy
        of this software and associated documentation files (the "Software"), to deal
        in the Software without restriction, including without limitation the rights
        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
        copies of the Software, and to permit persons to whom the Software is
        furnished to do so, subject to the following conditions:
        
        The above copyright notice and this permission notice shall be included in all
        copies or substantial portions of the Software.
        
        THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
        IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
        FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
        AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
        LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
        OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
        SOFTWARE.
