
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width" />
    <title>Challenge Mission</title>
    <!-- include libraries(jQuery, bootstrap) -->
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
    <!-- include summernote css/js-->
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.2/summernote.js"></script>
    <!-- include css-->
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
    <div class="container">
        <div class="header clearfix">
            <nav>
                <ul class="nav nav-pills pull-right">
                </ul>
            </nav>
            <h3 class="text-muted">Summernote Image Upload Example</h3>
        </div>
        <div class="row marketing">
            <div class="col-lg-12">
                <div class="form-area">
                    <form id="articleForm" role="form" action="/article" method="post">
                        <br style="clear: both">
                        <h3 style="margin-bottom: 25px;">Article Form</h3>
                        <div class="form-group">
                            <input type="text" class="form-control" id="subject" name="subject" placeholder="subject" required>
                        </div>
                        <div class="form-group">
                            <textarea class="form-control" id="summernote" name="content" placeholder="content" maxlength="140" rows="7"></textarea>
                        </div>
                        <button type="submit" id="submit" name="submit" class="btn btn-primary pull-right">Submit Form</button>
                    </form>
                </div>
            </div>
        </div>
        <div id="imageBoard">
            <ul>
                <c:forEach items="${files}" var="file">
                    <li><img src="/image/${file}" width="480" height="auto"/></li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <!-- /container -->
    <script type="text/javascript">
        $(document).ready(function() {
            $('#summernote').summernote({
                height: 300,
                minHeight: null,
                maxHeight: null,
                focus: true,
                callbacks: {
                    onImageUpload: function(files, editor, welEditable) {
                        for (let i = files.length - 1; i >= 0; i--) {
                            sendFile(files[i], this);
                        }
                    }
                }
            });
        });

        function sendFile(file, el) {
            const form_data = new FormData();
            form_data.append('file', file);
            $.ajax({
                data: form_data,
                type: "POST",
                url: '/image',
                cache: false,
                contentType: false,
                enctype: 'multipart/form-data',
                processData: false,
                success: function(url) {
                    $(el).summernote('editor.insertImage', url);
                    $('#imageBoard > ul').append('<li><img src="'+url+'" width="480" height="auto" alt="image"/></li>');
                }
            });
        }
    </script>
</body>
</html>