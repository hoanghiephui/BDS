/*
 * Copyright (c) 2017 Hoang Hiep.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.demobds.models;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * Created by hoanghiep on 7/23/17.
 */

public class User {
    public Date created_at;
    public String email;
    public boolean is_daily_push;
    public boolean is_info_push;
    public String phone;
    public int room_count;
    public String secure_token;
    public String status;
    public Date updated_at;
    public String user_name;
    public int user_no;
    public int user_type;

    public User() {
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
