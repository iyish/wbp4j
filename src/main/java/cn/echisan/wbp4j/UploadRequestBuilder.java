package cn.echisan.wbp4j;

import cn.echisan.wbp4j.http.DefaultWbpHttpRequest;
import cn.echisan.wbp4j.http.WbpHttpRequest;

/**
 * Created by echisan on 2018/11/5
 */
public class UploadRequestBuilder {
    private String username;
    private String password;
    private String cookieCacheName;
    private long tryLoginTime = 0;

    public UploadRequestBuilder setAcount(String username, String password) {
        this.username = username;
        this.password = password;
        return this;
    }

    public UploadRequestBuilder setCookieCacheName(String cookieCacheName) {
        this.cookieCacheName = cookieCacheName;
        return this;
    }

    public UploadRequestBuilder setTryLoginTime(long time) {
        this.tryLoginTime = time;
        return this;
    }

    public WbpUploadRequest build() {
        WbpHttpRequest request = new DefaultWbpHttpRequest();
        if (username == null) {
            throw new IllegalArgumentException("用户名不能为空!");
        }
        if (password == null) {
            throw new IllegalArgumentException("密码不能为空!");
        }
        WbpUploadRequest uploadRequest = new WbpUploadRequest(request, this.username, this.password);
        if (cookieCacheName != null) {
            CookieContext.defaultCookieFileName = this.cookieCacheName;
        }
        if (tryLoginTime != 0) {
            WbpUploadRequest.tryLoginTime = this.tryLoginTime;
        }
        return uploadRequest;
    }
}
