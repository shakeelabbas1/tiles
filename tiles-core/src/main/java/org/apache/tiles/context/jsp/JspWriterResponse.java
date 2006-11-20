/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package org.apache.tiles.context.jsp;

import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import java.io.PrintWriter;
import java.io.IOException;


public class JspWriterResponse extends HttpServletResponseWrapper {

    private PageContext context;
    private PrintWriter writer;

    public JspWriterResponse(PageContext pageContext) {
        super((HttpServletResponse)pageContext.getResponse());
        this.context = pageContext;
    }


    public PrintWriter getWriter() throws IOException {
        if(writer == null) {
            writer = new PrintWriter(context.getOut());
        }
        return writer;
    }
}