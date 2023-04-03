<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="是否使用" prop="isUsed">
        <el-input
          v-model="queryParams.isUsed"
          placeholder="请输入是否使用"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="remarks">
        <el-input
          v-model="queryParams.remarks"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="标题" prop="cTitle">
        <el-input
          v-model="queryParams.cTitle"
          placeholder="请输入标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="作者id" prop="cAuthorid">
        <el-input
          v-model="queryParams.cAuthorid"
          placeholder="请输入作者id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="音频id" prop="cVoice">
        <el-input
          v-model="queryParams.cVoice"
          placeholder="请输入音频id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="视频id" prop="cVideos">
        <el-input
          v-model="queryParams.cVideos"
          placeholder="请输入视频id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="会员作文" prop="cVip">
        <el-input
          v-model="queryParams.cVip"
          placeholder="请输入会员作文"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="级别" prop="cGrade">
        <el-input
          v-model="queryParams.cGrade"
          placeholder="请输入级别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="字数" prop="cWords">
        <el-input
          v-model="queryParams.cWords"
          placeholder="请输入字数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="点赞数" prop="cLikes">
        <el-input
          v-model="queryParams.cLikes"
          placeholder="请输入点赞数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评论数" prop="cDiscuss">
        <el-input
          v-model="queryParams.cDiscuss"
          placeholder="请输入评论数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="阅读次数" prop="cReadtimes">
        <el-input
          v-model="queryParams.cReadtimes"
          placeholder="请输入阅读次数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['resources:composition:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['resources:composition:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['resources:composition:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['resources:composition:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="compositionList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="是否使用" align="center" prop="isUsed" />
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="标题" align="center" prop="cTitle" />
      <el-table-column label="作者id" align="center" prop="cAuthorid" />
      <el-table-column label="简介/提要" align="center" prop="cSynopsis" />
      <!--<el-table-column label="内容" align="center" prop="cArticle" />-->
      <el-table-column label="图片大尺寸" align="center" prop="cImageb" />
      <el-table-column label="图片小尺寸" align="center" prop="cImages" />
      <el-table-column label="音频id" align="center" prop="cVoice" />
      <el-table-column label="视频id" align="center" prop="cVideos" />
      <el-table-column label="会员作文" align="center" prop="cVip" />
      <el-table-column label="级别" align="center" prop="cGrade" />
      <el-table-column label="类型" align="center" prop="cGatetype" />
      <el-table-column label="字数" align="center" prop="cWords" />
      <el-table-column label="状态" align="center" prop="cStatus" />
      <el-table-column label="点赞数" align="center" prop="cLikes" />
      <el-table-column label="评论数" align="center" prop="cDiscuss" />
      <el-table-column label="阅读次数" align="center" prop="cReadtimes" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['resources:composition:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['resources:composition:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改作文对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="是否使用" prop="isUsed">
          <el-input v-model="form.isUsed" placeholder="请输入是否使用" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="标题" prop="cTitle">
          <el-input v-model="form.cTitle" placeholder="请输入标题" />
        </el-form-item>
        <el-form-item label="作者id" prop="cAuthorid">
          <el-input v-model="form.cAuthorid" placeholder="请输入作者id" />
        </el-form-item>
        <el-form-item label="简介/提要" prop="cSynopsis">
          <el-input v-model="form.cSynopsis" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="内容" prop="cArticle">
          <el-input v-model="form.cArticle" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="图片大尺寸" prop="cImageb">
          <el-input v-model="form.cImageb" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="图片小尺寸" prop="cImages">
          <el-input v-model="form.cImages" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="音频id" prop="cVoice">
          <el-input v-model="form.cVoice" placeholder="请输入音频id" />
        </el-form-item>
        <el-form-item label="视频id" prop="cVideos">
          <el-input v-model="form.cVideos" placeholder="请输入视频id" />
        </el-form-item>
        <el-form-item label="会员作文" prop="cVip">
          <el-input v-model="form.cVip" placeholder="请输入会员作文" />
        </el-form-item>
        <el-form-item label="级别" prop="cGrade">
          <el-input v-model="form.cGrade" placeholder="请输入级别" />
        </el-form-item>
        <el-form-item label="字数" prop="cWords">
          <el-input v-model="form.cWords" placeholder="请输入字数" />
        </el-form-item>
        <el-form-item label="点赞数" prop="cLikes">
          <el-input v-model="form.cLikes" placeholder="请输入点赞数" />
        </el-form-item>
        <el-form-item label="评论数" prop="cDiscuss">
          <el-input v-model="form.cDiscuss" placeholder="请输入评论数" />
        </el-form-item>
        <el-form-item label="阅读次数" prop="cReadtimes">
          <el-input v-model="form.cReadtimes" placeholder="请输入阅读次数" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listComposition, getComposition, delComposition, addComposition, updateComposition } from "@/api/resources/composition";

export default {
  name: "Composition",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 作文表格数据
      compositionList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        isUsed: null,
        remarks: null,
        cTitle: null,
        cAuthorid: null,
        cSynopsis: null,
        cArticle: null,
        cImageb: null,
        cImages: null,
        cVoice: null,
        cVideos: null,
        cVip: null,
        cGrade: null,
        cGatetype: null,
        cWords: null,
        cStatus: null,
        cLikes: null,
        cDiscuss: null,
        cReadtimes: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询作文列表 */
    getList() {
      this.loading = true;
      listComposition(this.queryParams).then(response => {
        this.compositionList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        isUsed: null,
        createTime: null,
        updateTime: null,
        remarks: null,
        cTitle: null,
        cAuthorid: null,
        cSynopsis: null,
        cArticle: null,
        cImageb: null,
        cImages: null,
        cVoice: null,
        cVideos: null,
        cVip: null,
        cGrade: null,
        cGatetype: null,
        cWords: null,
        cStatus: null,
        cLikes: null,
        cDiscuss: null,
        cReadtimes: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加作文";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getComposition(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改作文";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateComposition(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addComposition(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除作文编号为"' + ids + '"的数据项？').then(function() {
        return delComposition(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('resources/composition/export', {
        ...this.queryParams
      }, `composition_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
